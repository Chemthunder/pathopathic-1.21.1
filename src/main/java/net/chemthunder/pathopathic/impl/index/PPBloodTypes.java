package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.compat.registrant.BloodTypeRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.BloodType;

public interface PPBloodTypes {
    BloodTypeRegistrant BLOOD_TYPES = new BloodTypeRegistrant(Pathopathic.MOD_ID);

    BloodType NEUTRAL = BLOOD_TYPES.register("neutral", 0xFF82172b, PPSymptoms.LETHARGIC);

    static void init() {}
}
