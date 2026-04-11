package net.chemthunder.pathopathic.impl.item;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.util.DiseaseUtils;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CoatedStickItem extends Item {
    public CoatedStickItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        DiseaseComponent disease = DiseaseComponent.KEY.get(user);

        if (user instanceof ServerPlayerEntity) {
            if (user.isSneaking()) {
                Disease generatedDisease = DiseaseUtils.generateRandomDisease();

                disease.setDisease(generatedDisease);
                disease.setDuration(1900);
            } else {
                user.sendMessage(Text.literal(disease.getDisease().name()));

                if (disease.getDisease().primary() != null && disease.getDisease().secondary() != null) {
                    user.sendMessage(Text.literal(disease.getDisease().primary().getName()));
                    user.sendMessage(Text.literal(disease.getDisease().secondary().getName()));
                }
                user.sendMessage(Text.literal(disease.getDisease().isViral() + ""));
                user.sendMessage(Text.literal(disease.getDisease().isLethal() + ""));
            }
        }
        return super.use(world, user, hand);
    }
}
