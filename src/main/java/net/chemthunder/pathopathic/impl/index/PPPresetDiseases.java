package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;

import java.util.ArrayList;
import java.util.List;

public interface PPPresetDiseases {
    List<Disease> DISEASES = new ArrayList<>();

    Disease LUNAR_LUCID = create("lunar_lucid", PPSymptoms.CANCEROUS, PPSymptoms.INSOMNIA, false, false);

    //

    private static Disease create(String name, Symptom primary, Symptom secondary, boolean isViral, boolean isLethal) {
        Disease gen = new Disease(name, primary, secondary, isViral, isLethal);
        DISEASES.add(gen);
        return gen;
    }

    static void init() {
        Disease.getAllDiseases().addAll(DISEASES);
    }
}