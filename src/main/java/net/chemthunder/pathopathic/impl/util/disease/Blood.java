package net.chemthunder.pathopathic.impl.util.disease;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record Blood(BloodType type, String giver) {
    public static final Blood EMPTY = new Blood(BloodType.EMPTY, "null");

    public static final Codec<Blood> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BloodType.CODEC.optionalFieldOf("name", BloodType.EMPTY).forGetter(Blood::type),
            Codec.STRING.optionalFieldOf("curedSymptom", "").forGetter(Blood::giver)
    ).apply(instance, Blood::new));

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
