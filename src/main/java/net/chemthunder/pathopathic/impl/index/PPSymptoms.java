package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.symptom.CancerousSymptom;
import net.chemthunder.pathopathic.impl.symptom.DizzySpellsSymptom;
import net.chemthunder.pathopathic.impl.symptom.WheezingSymptom;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;

import java.util.ArrayList;
import java.util.List;

public interface PPSymptoms {
    List<Symptom> SYMPTOMS = new ArrayList<>();

    Symptom CANCEROUS = new CancerousSymptom();
    Symptom DIZZY_SPELLS = new DizzySpellsSymptom();
    Symptom WHEEZING = new WheezingSymptom();

    Symptom LETHARGIC = create("lethargic");
    Symptom INSOMNIA = create("insomnia");
    Symptom SORENESS = create("soreness");
    Symptom DISTRACTED = create("distracted");
    Symptom CROSSEYED = create("crosseyed");
    Symptom WEIGHTED = create("weighted");
    Symptom HYDROPHOBIC = create("hydrophobic");
    Symptom PAROSMIC = create("parosmic");
    Symptom DYSPHORIC = create("dysphoric");

    private static Symptom create(String name) {
        Symptom gen = new Symptom(name);
        SYMPTOMS.add(gen);
        return gen;
    }

    static void init() {
        SYMPTOMS.add(CANCEROUS);
        SYMPTOMS.add(DIZZY_SPELLS);
        SYMPTOMS.add(WHEEZING);
    }
}