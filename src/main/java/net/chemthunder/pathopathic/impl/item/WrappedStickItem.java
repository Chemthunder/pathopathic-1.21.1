package net.chemthunder.pathopathic.impl.item;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.component.HeldDiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPDataComponents;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class WrappedStickItem extends Item {
    public WrappedStickItem(Settings settings) {
        super(settings.component(PPDataComponents.HELD_DISEASE, new HeldDiseaseComponent(PPDiseases.EMPTY)));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        var comp = stack.get(PPDataComponents.HELD_DISEASE);
        DiseaseComponent diseaseComponent = DiseaseComponent.KEY.get(user);

        if (user.isSneaking()) {
            if (!diseaseComponent.getDisease().isEmpty()) {
                if (comp != null) {
                    if (comp.disease().isEmpty()) {
                        stack.set(PPDataComponents.HELD_DISEASE, new HeldDiseaseComponent(diseaseComponent.getDisease()));
                        if (world.isClient) {
                            user.swingHand(hand);
                            user.playSoundToPlayer(SoundEvents.BLOCK_FROGSPAWN_HATCH, SoundCategory.PLAYERS, 1, 1);
                        }
                    }
                }
            }
        }

        return super.use(world, user, hand);
    }

//    public ActionResult useOnBlock(ItemUsageContext context) {
//        PlayerEntity player = context.getPlayer();
//        if (player != null) {
//            BlockState state = context.getWorld().getBlockState(context.getBlockPos());
//
//            ItemStack stack = player.getStackInHand(player.getActiveHand());
//            var comp = stack.get(PPDataComponents.HELD_DISEASE);
//
//            if (comp != null) {
//                if (state.isOf(Blocks.WATER_CAULDRON)) {
//                    if (context.getWorld().getBlockEntity(context.getBlockPos()) instanceof PathoCauldronBlockEntity cauldronBlockEntity) {
//                        cauldronBlockEntity.setHeldDisease(comp.disease());
//                    }
//                }
//            }
//        }
//        return super.useOnBlock(context);
//    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        HeldDiseaseComponent heldDisease = stack.getOrDefault(PPDataComponents.HELD_DISEASE, HeldDiseaseComponent.DEFAULT);
        Disease disease = heldDisease.disease();
        Symptom primary = disease.primary();
        Symptom secondary = disease.secondary();

        if (!disease.isEmpty()) {
            tooltip.add(Text.translatable(disease.getTranslationKey()).withColor(0xFFC6FC6F));
            tooltip.add(
                    Text.translatable(primary.getTranslationKey()).withColor(0xFFC6FC6F)
                            .append(Text.literal(", ").formatted(Formatting.DARK_GRAY))
                            .append(Text.translatable(secondary.getTranslationKey()).withColor(0xFFC6FC6F))
            );
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return oldStack.getItem() != newStack.getItem();
    }
}
