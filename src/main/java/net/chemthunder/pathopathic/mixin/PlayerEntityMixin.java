package net.chemthunder.pathopathic.mixin;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.component.HeldBloodComponent;
import net.chemthunder.pathopathic.impl.index.PPBloodTypes;
import net.chemthunder.pathopathic.impl.index.PPDataComponents;
import net.chemthunder.pathopathic.impl.index.tag.PPEntityTypeTags;
import net.chemthunder.pathopathic.impl.item.FoulPouchItem;
import net.chemthunder.pathopathic.impl.util.disease.Blood;
import net.chemthunder.pathopathic.impl.util.disease.BloodType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "attack", at = @At("HEAD"))
    private void pp$bloodObtainment(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.getOffHandStack().getItem() instanceof FoulPouchItem && player.getMainHandStack().isIn(ItemTags.SWORDS)) {
            var component = player.getOffHandStack().get(PPDataComponents.HELD_BLOOD);

            if (component != null) {
                BloodType type = null;


                if (target.getType().isIn(PPEntityTypeTags.REANIMATED)) {
                    type = PPBloodTypes.REANIMATED;
                }

                if (target.getType().isIn(PPEntityTypeTags.ENDER_BLOODED)) {
                    type = PPBloodTypes.ENDER;
                }

                if (target.getType().isIn(PPEntityTypeTags.NEUTRAL_BLOODED)) {
                    type = PPBloodTypes.NEUTRAL;
                }

                if (target.getType().isIn(PPEntityTypeTags.HUMANOID)) {
                    type = PPBloodTypes.HUMANOID;
                }

                if (type != null) {
                    String giver;

                    if (target instanceof PlayerEntity entity) {
                        giver = entity.getNameForScoreboard();
                    } else {
                        giver = target.getType().toString();
                    }

                    player.getOffHandStack().set(PPDataComponents.HELD_BLOOD,
                            new HeldBloodComponent(
                                    new Blood(
                                            type,
                                            giver
                                    )
                            )
                    );
                } else {
                    player.sendMessage(Text.translatable("text.pp.unable_to_extract"), true);
                }
            }
        }
    }
}
