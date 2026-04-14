package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.compat.registrant.DiseaseRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.Disease;

public interface PPDiseases {
    DiseaseRegistrant DISEASES = new DiseaseRegistrant(Pathopathic.MOD_ID);

    Disease EMPTY = DISEASES.register("empty",
            name -> new Disease(name, PPSymptoms.EMPTY, PPSymptoms.EMPTY, false, false));

    Disease LUNAR_LUCID = DISEASES.register("lunar_lucid",
            name -> new Disease(name, PPSymptoms.CANCEROUS, PPSymptoms.INSOMNIA, false, false));

    Disease DISTRACTED = DISEASES.register("distracted",
            name -> new Disease(name, PPSymptoms.DISTRACTED, PPSymptoms.EMPTY, false, false));

    Disease TEST = DISEASES.register("test",
            name -> new Disease(name, PPSymptoms.DISTRACTED, PPSymptoms.LETHARGIC, false, false));

    static void init() {}
}
