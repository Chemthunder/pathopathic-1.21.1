package net.chemthunder.pathopathic.impl;

import net.chemthunder.pathopathic.impl.index.PPDataComponents;
import net.chemthunder.pathopathic.impl.index.PPItems;
import net.chemthunder.pathopathic.impl.index.PPPresetDiseases;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pathopathic implements ModInitializer {
	public static final String MOD_ID = "pathopathic";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
        PPItems.init();
        PPDataComponents.init();
        PPSymptoms.init();
        PPPresetDiseases.init();

        /* Custom */
        PPSymptoms.init();
        PPPresetDiseases.init();

		LOGGER.info("Hello Fabric world!");
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}