package net.chemthunder.pathopathic.compat.registrant;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.BloodType;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.function.Function;

public class BloodTypeRegistrant extends RegistrantBase<BloodType> {
    public BloodTypeRegistrant(String modId) {
        super(modId, PPRegistries.BLOOD_TYPE);
    }

    public BloodType register(String name, Function<String, BloodType> bloodType) {
        return register(name, bloodType.apply(name));
    }

    public BloodType register(String name, int color, Symptom curedSymptom) {
        return register(name, new BloodType(name, color, curedSymptom));
    }

    public void registerLang(RegistryWrapper.WrapperLookup registries, FabricLanguageProvider.TranslationBuilder builder) {
        this.toRegister.forEach(bloodType -> builder.add(bloodType.getTranslationKey(), MiscUtils.formatString(bloodType.name())));
    }
}
