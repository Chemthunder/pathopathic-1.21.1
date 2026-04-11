package net.chemthunder.pathopathic.impl.item;

import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.component.HeldDiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPDataComponents;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class CoatedStickItem extends Item implements ModelVaryingItem {
    public CoatedStickItem(Settings settings) {
        super(settings
                .component(PPDataComponents.HELD_DISEASE, new HeldDiseaseComponent(Disease.EMPTY)));
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

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        var comp = stack.get(PPDataComponents.HELD_DISEASE);

        if (comp != null) {
            if (!comp.disease().isEmpty()) {
                Disease disease = comp.disease();



                tooltip.add(Text.literal(disease.name()).withColor(0xFFC6FC6F));
                tooltip.add(
                        Text.literal(disease.primary().getName())
                                .append(Text.literal(", ").formatted(Formatting.DARK_GRAY))
                                .append(Text.literal(disease.secondary().getName()))
                );
            }

        }
        super.appendTooltip(stack, context, tooltip, type);
    }

    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return oldStack.getItem() != newStack.getItem();
    }

    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {
        return Identifier.ofVanilla("stick");
    }

    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Identifier.ofVanilla("stick")
        );
    }
}
