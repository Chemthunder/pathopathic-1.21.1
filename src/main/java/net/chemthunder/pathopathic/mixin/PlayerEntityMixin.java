package net.chemthunder.pathopathic.mixin;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.tag.PPSymptomTags;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow public abstract String getNameForScoreboard();

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        DiseaseComponent component = DiseaseComponent.KEY.get(this);

        if (component.getDisease().hasSymptomIn(PPSymptomTags.DISABLES_SPRINTING)) {
            //Pathopathic.LOGGER.info("Player {} is Lethargic!", this.getNameForScoreboard());
        }
    }
}
