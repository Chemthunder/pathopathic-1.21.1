package net.chemthunder.pathopathic.impl.index;

import net.acoyt.acornlib.api.registrants.ComponentTypeRegistrant;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.component.HeldDiseaseComponent;
import net.minecraft.component.ComponentType;

public interface PPDataComponents {
    ComponentTypeRegistrant COMPONENTS = new ComponentTypeRegistrant(Pathopathic.MOD_ID);

    ComponentType<HeldDiseaseComponent> HELD_DISEASE = COMPONENTS.register("held_disease",
            builder -> builder
                    .codec(HeldDiseaseComponent.CODEC)
                    .packetCodec(HeldDiseaseComponent.PACKET_CODEC));

    static void init() {}
}
