package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public record BloodType(String name, int color, RegistryEntry<Symptom> curedSymptom) {
    public static final BloodType EMPTY = new BloodType("null", 0xFFffffff, PPSymptoms.EMPTY);

    public static final Codec<BloodType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("name", "Empty").forGetter(BloodType::name),
            Codec.INT.optionalFieldOf("color", 0xFFffffff).forGetter(BloodType::color),
            Symptom.CODEC.optionalFieldOf("curedSymptom", PPSymptoms.EMPTY).forGetter(BloodType::curedSymptom)
    ).apply(instance, BloodType::new));

    public boolean isEmpty() {
        return this == EMPTY;
    }

    public String getTranslationKey() {
        return Util.createTranslationKey("blood_type", getId(this));
    }

    public static Identifier getId(BloodType bloodType) {
        return PPRegistries.BLOOD_TYPE.getId(bloodType);
    }
}
