package net.chemthunder.pathopathic.impl.index.tag;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public interface PPEntityTypeTags {
    TagKey<EntityType<?>> NEUTRAL_BLOODED = create("neutral_blooded");
    TagKey<EntityType<?>> REANIMATED = create("reanimated");
    TagKey<EntityType<?>> ENDER_BLOODED = create("ender_blooded");
    TagKey<EntityType<?>> HUMANOID = create("humanoid");

    private static TagKey<EntityType<?>> create(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, Pathopathic.id(id));
    }
}
