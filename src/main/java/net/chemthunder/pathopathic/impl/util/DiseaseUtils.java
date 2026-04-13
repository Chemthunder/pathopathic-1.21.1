package net.chemthunder.pathopathic.impl.util;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.Symptoms;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;

import java.util.List;
import java.util.Random;

public class DiseaseUtils {
    private static final List<String> PREFIXES = List.of(
            "trans",
            "gay",
            "german",
            "pre",
            "fix",
            "bre",
            "pickle",
            "untitled",
            "homo",
            "",
            "necro",
            "hydro",
            "plate",
            "avogadro",
            "sexually Transmitted "
    );
    private static final List<String> SUFFIXES = List.of(
            "incantation",
            "wizard",
            "ed",
            "PANZERKAMPFWAGEN",
            "suh",
            "itus",
            "mania",
            " Syndrome",
            "inator",
            "phobic",
            "",
            " Infliction",
            "mancy",
            " Iysteria"
    );
    private static final List<String> BLACKLIST = List.of(
            "neonazi",
            " "
    );

    public static String generateName() {
        Random random = new Random();
        String returnedString = PREFIXES.get(random.nextInt(PREFIXES.size())) + SUFFIXES.get(random.nextInt(SUFFIXES.size()));

        if (BLACKLIST.contains(returnedString)) {
            return "redacted";
        }

        return MiscUtils.formatString(returnedString);
    }

    public static Disease generateRandomDisease() {
        Random random = new Random();
        return new Disease(MiscUtils.formatString(generateName()), Symptoms.SYMPTOMS.get(random.nextInt(Symptoms.SYMPTOMS.size())), Symptoms.SYMPTOMS.get(random.nextInt(Symptoms.SYMPTOMS.size())), false, false);
    }

    public static boolean diseaseHasSymptom(Symptom symptom, Disease disease) {
        return disease.primary() != null && disease.primary().equals(symptom) || disease.secondary() != null && disease.secondary().equals(symptom);
    }
}
