package net.chemthunder.pathopathic.data.provider;

import net.chemthunder.pathopathic.impl.index.Symptoms;
import net.chemthunder.pathopathic.impl.index.tag.PPSymptomTags;
import net.chemthunder.pathopathic.impl.util.PPRegistryKeys;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PPSymptomTagGen extends FabricTagProvider<Symptom> {
    public PPSymptomTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, PPRegistryKeys.SYMPTOM, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(PPSymptomTags.DISABLES_SPRINTING)
                .add(Symptoms.LETHARGIC)
                .setReplace(false);
    }
}
