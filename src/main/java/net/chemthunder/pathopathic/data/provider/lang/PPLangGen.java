package net.chemthunder.pathopathic.data.provider.lang;

import net.chemthunder.pathopathic.impl.index.PPBloodTypes;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.index.PPItems;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PPLangGen extends FabricLanguageProvider {
    public PPLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup registries, TranslationBuilder builder) {
        PPItems.ITEMS.registerLang(registries, builder);
        PPDiseases.DISEASES.registerLang(registries, builder);
        PPSymptoms.SYMPTOMS.registerLang(registries, builder);
        PPBloodTypes.BLOOD_TYPES.registerLang(registries, builder);

        builder.add("text.pp.cure", "Cures ");
        builder.add("text.pp.giver", "Given by ");
        builder.add("text.pp.unable_to_extract", "You are unable to extract blood from this entity.");
    }
}
