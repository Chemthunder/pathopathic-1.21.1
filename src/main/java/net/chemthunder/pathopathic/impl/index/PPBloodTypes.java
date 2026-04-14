package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.compat.registrant.BloodTypeRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.BloodType;

public interface PPBloodTypes {
    BloodTypeRegistrant BLOOD_TYPES = new BloodTypeRegistrant(Pathopathic.MOD_ID);

    BloodType EMPTY = BLOOD_TYPES.register("empty", 0xFFffffff, PPSymptoms.EMPTY);

    BloodType NEUTRAL = BLOOD_TYPES.register("neutral", 0xFF82172b, PPSymptoms.LETHARGIC);
    BloodType REANIMATED = BLOOD_TYPES.register("reanimated", 0xFF621aab, PPSymptoms.DISTRACTED);
    BloodType ENDER = BLOOD_TYPES.register("ender", 0xFFb980f2, PPSymptoms.CANCEROUS);
    BloodType HUMANOID = BLOOD_TYPES.register("humanoid", 0xFF97ed68, PPSymptoms.INSOMNIA);

    static void init() {}
}
