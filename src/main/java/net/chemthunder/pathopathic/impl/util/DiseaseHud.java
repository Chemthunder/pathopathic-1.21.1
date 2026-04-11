package net.chemthunder.pathopathic.impl.util;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.StringHelper;

import java.util.List;

public class DiseaseHud {
    public static void render(DrawContext drawContext) {
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;

        if (player != null) {
            DiseaseComponent disease = DiseaseComponent.KEY.get(player);

            if (disease.getDisease() != Disease.EMPTY) {
                if (client.world != null) {
                    MutableText duration;
                    if (disease.getDuration() != -1) {
                        duration = Text.literal(StringHelper.formatTicks(disease.getDuration(), client.world.getTickManager().getTickRate())).formatted(Formatting.DARK_GRAY);
                    } else {
                        duration = Text.literal("∞").formatted(Formatting.DARK_GRAY);
                    }

                    List<Text> contents = List.of(
                            Text.of(Text.literal(MiscUtils.formatString(disease.getDisease().name())).withColor(0xFFC6FC6F)),
                            Text.of(Text.literal(MiscUtils.formatString(disease.getDisease().primary().name)).withColor(0xFFC6FC6F).append(Text.of(", ")).append(Text.literal(MiscUtils.formatString(disease.getDisease().secondary().name)).withColor(0xFFC6FC6F))),
                            Text.of(duration)
                    );

                    drawContext.drawTooltip(client.textRenderer,
                            contents,
                            drawContext.getScaledWindowWidth() / 2 + 90,
                            drawContext.getScaledWindowHeight() / 2 + 90
                    );
                }
            }
        }
    }

//    public static Text getDurationText(Disease disease, float multiplier, float tickRate) {
//        if (effect.isInfinite()) {
//            return Text.translatable("effect.duration.infinite");
//        } else {
//            int i = MathHelper.floor((float)effect.getDuration() * multiplier);
//            return Text.literal(StringHelper.formatTicks(i, tickRate));
//        }
//    }
}
