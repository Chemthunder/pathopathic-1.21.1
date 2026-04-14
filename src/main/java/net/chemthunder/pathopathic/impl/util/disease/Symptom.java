package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.index.PPSymptoms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Objects;

public class Symptom {
    public static final Codec<Symptom> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("name", "empty").forGetter(Symptom::getName)
    ).apply(instance, Symptom::new));

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
