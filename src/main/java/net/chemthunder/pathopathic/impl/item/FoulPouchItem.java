package net.chemthunder.pathopathic.impl.item;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.component.HeldBloodComponent;
import net.chemthunder.pathopathic.impl.index.PPDataComponents;
import net.chemthunder.pathopathic.impl.util.disease.Blood;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class FoulPouchItem extends Item {
    public FoulPouchItem(Settings settings) {
        super(settings.component(PPDataComponents.HELD_BLOOD, HeldBloodComponent.DEFAULT));
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        var blood = stack.get(PPDataComponents.HELD_BLOOD);

        if (blood != null) {
            if (blood.blood() != Blood.EMPTY) {

            }
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        var component = stack.get(PPDataComponents.HELD_BLOOD);

        if (component != null) {
            Blood blood = component.blood();

            if (!blood.isEmpty()) {
                tooltip.add(Text.translatable(blood.type().getTranslationKey()).withColor(blood.type().color()));
                tooltip.add(Text.translatable("text.pp.cure").formatted(Formatting.DARK_GRAY).append(Text.literal(MiscUtils.formatString(blood.type().curedSymptom().getName())).withColor(blood.type().color())));
                tooltip.add(Text.translatable("text.pp.giver").formatted(Formatting.DARK_GRAY).append(Text.translatable(blood.giver()).withColor(blood.type().color())));
            }
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
