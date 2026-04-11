package net.chemthunder.pathopathic.mixin.client;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.chemthunder.pathopathic.impl.util.DiseaseUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @Inject(method = "canSprint", at = @At("HEAD"), cancellable = true)
    private void pp$disableSprinting(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = MinecraftClient.getInstance().player;

        if (player != null) {
            DiseaseComponent disease = DiseaseComponent.KEY.get(player);

            if (DiseaseUtils.diseaseHasSymptom(PPSymptoms.LETHARGIC, disease.getDisease())) {
                cir.setReturnValue(false);
            }
        }
    }
}
