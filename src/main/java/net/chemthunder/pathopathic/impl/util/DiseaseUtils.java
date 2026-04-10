package net.chemthunder.pathopathic.impl.util;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
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
            "sexually transmitted "
    );
    private static final List<String> SUFFIXES = List.of(
            "incantation",
            "wizard",
            "ed",
            "PANZERKAMPFWAGEN",
            "suh",
            "itus",
            "mania",
            " syndrome",
            "inator",
            "phobic",
            "",
            " infliction",
            "mancy",
            " hysteria"
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
        return new Disease(generateName(), PPSymptoms.INSOMNIA, PPSymptoms.INSOMNIA, false, false);
    }

    public static boolean diseaseHasSymptom(Symptom symptom, Disease disease) {
        return disease.primary() != null && disease.primary().equals(symptom) || disease.secondary() != null && disease.secondary().equals(symptom);
    }
}
