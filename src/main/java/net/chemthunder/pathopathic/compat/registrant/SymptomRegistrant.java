package net.chemthunder.pathopathic.compat.registrant;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.function.Function;

public class SymptomRegistrant extends RegistrantBase<Symptom> {
    public SymptomRegistrant(String modId) {
        super(modId, PPRegistries.SYMPTOM);
    }

    public Symptom register(String name, Function<String, Symptom> symptom) {
        return register(name, symptom.apply(name));
    }

    public Symptom register(String name) {
        return register(name, new Symptom(name));
    }

    public RegistryEntry<Symptom> registerRef(String name, Function<String, Symptom> symptom) {
        Symptom builtSymptom = symptom.apply(name);
        this.toRegister.add(builtSymptom);
        return Registry.registerReference(PPRegistries.SYMPTOM, this.id(name), builtSymptom);
    }

    public void registerLang(RegistryWrapper.WrapperLookup registries, FabricLanguageProvider.TranslationBuilder builder) {
        this.toRegister.forEach(symptom -> builder.add(symptom.getTranslationKey(), MiscUtils.formatString(symptom.getName())));
    }
}
