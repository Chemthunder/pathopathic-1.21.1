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

    Symptom EMPTY = SYMPTOMS.register("empty", Symptom::new);

    Symptom CANCEROUS = SYMPTOMS.register("cancerous", CancerousSymptom::new);
    Symptom DIZZY_SPELLS = SYMPTOMS.register("dizzy_spells", DizzySpellsSymptom::new);
    Symptom WHEEZING = SYMPTOMS.register("wheezing", WheezingSymptom::new);

    Symptom LETHARGIC = SYMPTOMS.register("lethargic", Symptom::new);
    Symptom INSOMNIA = SYMPTOMS.register("insomnia", Symptom::new);
    Symptom SORENESS = SYMPTOMS.register("soreness", Symptom::new);
    Symptom DISTRACTED = SYMPTOMS.register("distracted", Symptom::new);
    Symptom CROSS_EYED = SYMPTOMS.register("cross_eyed", Symptom::new);
    Symptom WEIGHTED = SYMPTOMS.register("weighted", Symptom::new);
    Symptom HYDROPHOBIC = SYMPTOMS.register("hydrophobic", Symptom::new);
    Symptom PAROSMIC = SYMPTOMS.register("parosmic", Symptom::new);
    Symptom DYSPHORIC = SYMPTOMS.register("dysphoric", Symptom::new);
    Symptom BLUE = SYMPTOMS.register("blue", Symptom::new);

    static void init() {}
}
