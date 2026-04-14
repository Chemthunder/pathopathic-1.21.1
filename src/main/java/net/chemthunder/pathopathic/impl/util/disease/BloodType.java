package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record BloodType(String name) {
    public static final BloodType EMPTY = new BloodType("null");

    public static final Codec<BloodType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("name", "").forGetter(BloodType::name)
    ).apply(instance, BloodType::new));
}
