package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public interface PPRegistries {
    RegistryKey<Registry<Disease>> diseaseKey = RegistryKey.ofRegistry(Pathopathic.id("disease"));
    Registry<Disease> DISEASE = FabricRegistryBuilder.createDefaulted(diseaseKey, Pathopathic.id("empty"))
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    RegistryKey<Registry<Symptom>> symptomKey = RegistryKey.ofRegistry(Pathopathic.id("symptom"));
    Registry<Symptom> SYMPTOM = FabricRegistryBuilder.createDefaulted(symptomKey, Pathopathic.id("empty"))
            .attribute(RegistryAttribute.MODDED)
            .buildAndRegister();

    static void init() {}
}
