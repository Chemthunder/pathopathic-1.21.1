package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.List;

public record Disease(String name, Symptom primary, Symptom secondary, boolean viral, boolean lethal) {
    public static final Codec<Disease> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("name", "empty").forGetter(Disease::name),
            Symptom.CODEC.optionalFieldOf("primary", PPSymptoms.EMPTY).forGetter(Disease::primary),
            Symptom.CODEC.optionalFieldOf("secondary", PPSymptoms.EMPTY).forGetter(Disease::secondary),
            Codec.BOOL.optionalFieldOf("viral", false).forGetter(Disease::viral),
            Codec.BOOL.optionalFieldOf("lethal", false).forGetter(Disease::lethal)
    ).apply(instance, Disease::new));

    public static Disease fromString(String name) {
        for (Disease disease : PPRegistries.DISEASE) {
            if (disease.name.equalsIgnoreCase(name)) {
                return disease;
            }
        }

        return PPDiseases.EMPTY;
    }

    public List<Symptom> getSymptoms() {
        return Arrays.asList(this.primary, this.secondary);
    }

    public boolean isEmpty() {
        return this == PPDiseases.EMPTY;
    }

    public String getTranslationKey() {
        return Util.createTranslationKey("disease", getId(this));
    }

    public static Identifier getId(Disease disease) {
        return PPRegistries.DISEASE.getId(disease);
    }
}
