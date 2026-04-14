package net.chemthunder.pathopathic.impl.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.chemthunder.pathopathic.impl.util.disease.Blood;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;

public record HeldBloodComponent(Blood blood) {
    public static final HeldBloodComponent DEFAULT = new HeldBloodComponent(Blood.EMPTY);

    public static final Codec<HeldBloodComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Blood.CODEC.optionalFieldOf("blood", Blood.EMPTY).forGetter(HeldBloodComponent::blood)
    ).apply(instance, HeldBloodComponent::new));

    public static final PacketCodec<ByteBuf, HeldBloodComponent> PACKET_CODEC = PacketCodecs.codec(CODEC);
}
