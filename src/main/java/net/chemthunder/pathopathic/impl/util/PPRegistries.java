package net.chemthunder.pathopathic.impl.util;

import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;

public interface PPRegistries {
    Registry<Symptom> SYMPTOM = FabricRegistryBuilder.createSimple(PPRegistryKeys.SYMPTOM)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    Registry<Disease> DISEASE = FabricRegistryBuilder.createSimple(PPRegistryKeys.DISEASE)
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();
}
