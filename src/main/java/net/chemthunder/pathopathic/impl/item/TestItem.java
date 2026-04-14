package net.chemthunder.pathopathic.impl.item;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.util.DiseaseUtils;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestItem extends Item {
    public TestItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        DiseaseComponent component = DiseaseComponent.KEY.get(user);
        Disease disease = component.getDisease();
        Symptom primary = disease.primary().value();
        Symptom secondary = disease.secondary().value();

        if (user instanceof ServerPlayerEntity) {
            if (user.isSneaking()) {
                Disease generatedDisease = DiseaseUtils.generateRandomDisease();

                component.setDisease(generatedDisease);
                component.setDuration(1900);
            } else {
                user.sendMessage(Text.literal(disease.name()));

                if (primary != null && secondary != null) {
                    user.sendMessage(Text.literal(primary.getName()));
                    user.sendMessage(Text.literal(secondary.getName()));
                }

                user.sendMessage(Text.literal(String.valueOf(disease.viral())));
                user.sendMessage(Text.literal(String.valueOf(disease.lethal())));
            }
        }

        return super.use(world, user, hand);
    }
}
