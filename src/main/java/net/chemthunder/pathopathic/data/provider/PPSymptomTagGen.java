package net.chemthunder.pathopathic.data.provider;

import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.chemthunder.pathopathic.impl.index.tag.PPSymptomTags;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PPSymptomTagGen extends FabricTagProvider<Symptom> {
    public PPSymptomTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, PPRegistries.symptomKey, registriesFuture);
    }

    public void configure(RegistryWrapper.WrapperLookup registries) {
        this.getOrCreateTagBuilder(PPSymptomTags.DISABLES_SPRINTING)
                .add(PPSymptoms.LETHARGIC.value())
                .setReplace(false);
    }
}
