package net.chemthunder.pathopathic.impl.util;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
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
            "avogadro"
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
            return generateName(); // re-rolls name
        }

        return MiscUtils.formatString(returnedString);
    }

    public static Disease generateRandomDisease() {
        Random random = new Random();
        return PPRegistries.DISEASE.get(random.nextInt(PPRegistries.DISEASE.size()));
    }

    public static boolean diseaseHasSymptom(Symptom symptom, Disease disease) {
        return disease.getSymptoms().contains(symptom);
    }
}
