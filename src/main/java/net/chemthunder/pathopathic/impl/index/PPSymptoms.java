package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.symptom.CancerousSymptom;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;

import java.util.ArrayList;
import java.util.List;

public interface PPSymptoms {
    List<Symptom> SYMPTOMS = new ArrayList<>();

    Symptom CANCEROUS = new CancerousSymptom("cancerous");

    Symptom LETHARGIC = create("lethargic");
    Symptom INSOMNIA = create("insomnia");

    private static Symptom create(String name) {
        Symptom gen = new Symptom(name);
        SYMPTOMS.add(gen);
        return gen;
    }

    static void init() {
        SYMPTOMS.add(CANCEROUS);
    }
}
