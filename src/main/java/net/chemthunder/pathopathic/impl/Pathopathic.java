package net.chemthunder.pathopathic.impl;

import net.chemthunder.pathopathic.impl.index.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pathopathic implements ModInitializer {
    public static final String MOD_ID = "pathopathic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public void onInitialize() {
        PPBlockEntities.init();
        PPDataComponents.init();
        PPItemGroups.init();
        PPItems.init();

        /* Custom */
        PPDiseases.init();
        PPSymptoms.init();
        PPRegistries.init();

        LOGGER.info("Disease time!!!");
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
