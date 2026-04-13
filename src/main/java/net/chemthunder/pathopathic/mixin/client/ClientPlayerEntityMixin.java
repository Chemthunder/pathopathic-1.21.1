package net.chemthunder.pathopathic.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.Symptoms;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @ModifyReturnValue(method = "canSprint", at = @At("RETURN"))
    private boolean pp$disableSprint(boolean original) {
        PlayerEntity player = MinecraftClient.getInstance().player;

        if (player != null) {
            DiseaseComponent disease = DiseaseComponent.KEY.get(player);

            if (disease.getDisease().primary().equals(Symptoms.LETHARGIC) || disease.getDisease().secondary().equals(Symptoms.LETHARGIC)) {
                return false;
            }
        }
        return original;
    }
}
