package net.chemthunder.pathopathic.impl.index.tag;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.registry.tag.TagKey;

public interface PPSymptomTags {
    TagKey<Symptom> DISABLES_SPRINTING = create("disables_sprinting");

    private static TagKey<Symptom> create(String id) {
        return TagKey.of(PPRegistries.symptomKey, Pathopathic.id(id));
    }
}
