package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Objects;

public class Symptom {
    public static final Codec<RegistryEntry<Symptom>> CODEC = PPRegistries.SYMPTOM
            .getEntryCodec()
            .validate(entry -> entry.matches(Objects::isNull) || entry.matches(PPSymptoms.EMPTY) ? DataResult.error(() -> "Symptom cannot be null") : DataResult.success(entry));

    private final String name;

    public Symptom(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return this == PPSymptoms.EMPTY;
    }

    public String getName() {
        return this.name;
    }

    public String getTranslationKey() {
        return Util.createTranslationKey("symptom", getId(this));
    }

    public static Identifier getId(Symptom symptom) {
        return PPRegistries.SYMPTOM.getId(symptom);
    }

    public void getTickingEffect(LivingEntity living) {}
    public void getHitEffect(LivingEntity living, LivingEntity target) {}
}
