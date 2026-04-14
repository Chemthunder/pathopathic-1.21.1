package net.chemthunder.pathopathic.impl.item;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FoulPouchItem extends Item {
    public FoulPouchItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        DiseaseComponent component = DiseaseComponent.KEY.get(user);

        component.setDisease(PPDiseases.TEST);
        component.setDuration(1900);

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
