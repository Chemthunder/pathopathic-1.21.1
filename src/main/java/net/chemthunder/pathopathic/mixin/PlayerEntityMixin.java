package net.chemthunder.pathopathic.mixin;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.Symptoms;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        DiseaseComponent component = DiseaseComponent.KEY.get(player);

        if (!player.getWorld().isClient) {
            if (component.getDisease() != Disease.EMPTY) {
                if (component.getDisease().primary().equals(Symptoms.LETHARGIC) || component.getDisease().secondary().equals(Symptoms.LETHARGIC)) {
                    Pathopathic.LOGGER.info("penis");
                }
            }
        }
    }
}
