package net.chemthunder.pathopathic.compat.registrant;

import net.acoyt.acornlib.api.template.RegistrantBase;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.function.Function;

public class DiseaseRegistrant extends RegistrantBase<Disease> {
    public DiseaseRegistrant(String modId) {
        super(modId, PPRegistries.DISEASE);
    }

    public Disease register(String name, Function<String, Disease> disease) {
        return register(name, disease.apply(name));
    }

    public Disease register(String name, Symptom primary, Symptom secondary, boolean viral, boolean lethal) {
        return register(name, new Disease(name, primary, secondary, viral, lethal));
    }

    public void registerLang(RegistryWrapper.WrapperLookup registries, FabricLanguageProvider.TranslationBuilder builder) {
        this.toRegister.forEach(disease -> builder.add(disease.getTranslationKey(), MiscUtils.formatString(disease.name())));
    }
}
