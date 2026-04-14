package net.chemthunder.pathopathic.data;

import net.chemthunder.pathopathic.data.provider.PPEntityTypeTagGen;
import net.chemthunder.pathopathic.data.provider.lang.PPLangGen;
import net.chemthunder.pathopathic.data.provider.resources.PPModelGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PathopathicDataGen implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(PPLangGen::new);

        pack.addProvider(PPModelGen::new);

        pack.addProvider(PPEntityTypeTagGen::new);
    }
}
