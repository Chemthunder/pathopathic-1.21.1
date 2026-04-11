package net.chemthunder.pathopathic.impl.item;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPPresetDiseases;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
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
        DiseaseComponent disease = DiseaseComponent.KEY.get(user);

        disease.setDisease(new Disease("test", PPSymptoms.DISTRACTED, PPSymptoms.DISTRACTED, false, false));
        disease.setDuration(-1);
        return super.use(world, user, hand);
    }
}
