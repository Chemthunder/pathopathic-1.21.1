package net.chemthunder.pathopathic.mixin.client;

import net.chemthunder.pathopathic.impl.util.DiseaseHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractInventoryScreen.class)
public abstract class AbstractInventoryScreenMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void pp$diseaseReadout(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        DiseaseHud.render(context);
    }
}
