package net.chemthunder.pathopathic.impl.index.tag;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.registry.tag.TagKey;

public interface PPDiseaseTags {
    private static TagKey<Disease> create(String id) {
        return TagKey.of(PPRegistries.diseaseKey, Pathopathic.id(id));
    }
}
