package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public record Disease(String name, Symptom primary, Symptom secondary, boolean isViral, boolean isLethal) {
    public static final Disease EMPTY = new Disease("null", Symptom.EMPTY, Symptom.EMPTY, false, false);
    public static List<Disease> ALL_DISEASES = new ArrayList<>();

    public static final Codec<Disease> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.optionalFieldOf("name", "").forGetter(Disease::name),
                    Symptom.CODEC.optionalFieldOf("primary", Symptom.EMPTY).forGetter(Disease::primary),
                    Symptom.CODEC.optionalFieldOf("secondary", Symptom.EMPTY).forGetter(Disease::secondary),
                    Codec.BOOL.optionalFieldOf("isViral", false).forGetter(Disease::isViral),
                    Codec.BOOL.optionalFieldOf("isLethal", false).forGetter(Disease::isLethal)
            ).apply(instance, Disease::new)
    );

    public static List<Disease> getAllDiseases() {
        ALL_DISEASES.add(EMPTY);
        return ALL_DISEASES;
    }

    public static Disease fromString(String name) {
        return ALL_DISEASES.stream().filter(disease -> disease.name().equalsIgnoreCase(name)).findFirst().orElse(EMPTY);
    }

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
