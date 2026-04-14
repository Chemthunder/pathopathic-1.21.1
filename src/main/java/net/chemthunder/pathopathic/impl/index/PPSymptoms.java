package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.compat.registrant.SymptomRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.symptom.CancerousSymptom;
import net.chemthunder.pathopathic.impl.symptom.DizzySpellsSymptom;
import net.chemthunder.pathopathic.impl.symptom.WheezingSymptom;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.registry.entry.RegistryEntry;

public interface PPSymptoms {
    SymptomRegistrant SYMPTOMS = new SymptomRegistrant(Pathopathic.MOD_ID);

    RegistryEntry<Symptom> EMPTY = SYMPTOMS.registerRef("empty", Symptom::new);

    RegistryEntry<Symptom> CANCEROUS = SYMPTOMS.registerRef("cancerous", CancerousSymptom::new);
    RegistryEntry<Symptom> DIZZY_SPELLS = SYMPTOMS.registerRef("dizzy_spells", DizzySpellsSymptom::new);
    RegistryEntry<Symptom> WHEEZING = SYMPTOMS.registerRef("wheezing", WheezingSymptom::new);

    RegistryEntry<Symptom> LETHARGIC = SYMPTOMS.registerRef("lethargic", Symptom::new);
    RegistryEntry<Symptom> INSOMNIA = SYMPTOMS.registerRef("insomnia", Symptom::new);
    RegistryEntry<Symptom> SORENESS = SYMPTOMS.registerRef("soreness", Symptom::new);
    RegistryEntry<Symptom> DISTRACTED = SYMPTOMS.registerRef("distracted", Symptom::new);
    RegistryEntry<Symptom> CROSS_EYED = SYMPTOMS.registerRef("cross_eyed", Symptom::new);
    RegistryEntry<Symptom> WEIGHTED = SYMPTOMS.registerRef("weighted", Symptom::new);
    RegistryEntry<Symptom> HYDROPHOBIC = SYMPTOMS.registerRef("hydrophobic", Symptom::new);
    RegistryEntry<Symptom> PAROSMIC = SYMPTOMS.registerRef("parosmic", Symptom::new);
    RegistryEntry<Symptom> DYSPHORIC = SYMPTOMS.registerRef("dysphoric", Symptom::new);

    static void init() {}
}
