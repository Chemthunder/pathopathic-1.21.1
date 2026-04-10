package net.chemthunder.pathopathic.impl.client.event;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class DiseaseReadoutEvent implements HudRenderCallback {
    public void onHudRender(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {
            DiseaseComponent disease = DiseaseComponent.KEY.get(player);

            if (disease.getDisease() != null) {
//                List<Text> contents = List.of(
//                        Text.of(Text.literal(MiscUtils.formatString(disease.getDisease().name()))),
//                        Text.of(Text.literal(MiscUtils.formatString(disease.getDisease().primary().name)) + ", " + MiscUtils.formatString(disease.getDisease().secondary().name)),
//                        Text.of(Text.literal(disease.getDuration() + "").formatted(Formatting.DARK_GRAY))
//                );

                drawContext.drawTextWithBackground(client.textRenderer,
                        Text.literal(disease.getDisease().name()),
                        drawContext.getScaledWindowWidth() / 2,
                        drawContext.getScaledWindowHeight() / 2,
                        120,
                        0xFFffffff
                );
            }
        }
    }
}
