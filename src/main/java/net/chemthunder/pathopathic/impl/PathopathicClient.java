package net.chemthunder.pathopathic.impl;

import net.chemthunder.pathopathic.impl.index.PPBlockEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class PathopathicClient implements ClientModInitializer {
    public void onInitializeClient() {
        PPBlockEntities.clientInit();
    }
}
