package net.chemthunder.pathopathic.impl;

import net.chemthunder.pathopathic.impl.client.event.DiseaseReadoutEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class PathopathicClient implements ClientModInitializer {
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(new DiseaseReadoutEvent());
    }
}
