package net.chemthunder.pathopathic.impl.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record HeldDiseaseComponent(Disease disease) {
    public static final HeldDiseaseComponent DEFAULT = new HeldDiseaseComponent(PPDiseases.EMPTY);

    public static final Codec<HeldDiseaseComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Disease.CODEC.optionalFieldOf("heldDisease", PPDiseases.EMPTY).forGetter(HeldDiseaseComponent::disease)
    ).apply(instance, HeldDiseaseComponent::new));

    public static final PacketCodec<ByteBuf, HeldDiseaseComponent> PACKET_CODEC = PacketCodecs.codec(CODEC);
}
