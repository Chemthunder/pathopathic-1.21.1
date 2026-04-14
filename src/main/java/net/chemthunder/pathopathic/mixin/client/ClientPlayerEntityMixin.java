package net.chemthunder.pathopathic.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.tag.PPSymptomTags;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin {

    @ModifyReturnValue(method = "canSprint", at = @At("RETURN"))
    private boolean pp$disableSprint(boolean original) {
        DiseaseComponent component = DiseaseComponent.KEY.get(this);
        if (component.getDisease().hasSymptomIn(PPSymptomTags.DISABLES_SPRINTING)) {
            return false;
        }

        return original;
    }
}
