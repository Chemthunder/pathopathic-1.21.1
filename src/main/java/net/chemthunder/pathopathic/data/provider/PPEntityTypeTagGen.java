package net.chemthunder.pathopathic.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class PPEntityTypeTagGen extends FabricTagProvider.EntityTypeTagProvider {
    public PPEntityTypeTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup lookup) {
//        this.getOrCreateTagBuilder(PPEntityTypeTags.NEUTRAL_BLOODED)
//                .add(COW)
//                .add(DONKEY)
//                .add(HORSE)
//                .add(CHICKEN)
//                .add(PIG)
//                .add(RABBIT)
//                .add(SHEEP)
//                .add(SILVERFISH)
//                .setReplace(false);
//
//        this.getOrCreateTagBuilder(PPEntityTypeTags.ENDER_BLOODED)
//                .add(ENDERMAN)
//                .add(ENDERMITE)
//                .add(ENDER_DRAGON)
//                .setReplace(false);
//
//        this.getOrCreateTagBuilder(PPEntityTypeTags.REANIMATED)
//                .addOptionalTag(EntityTypeTags.UNDEAD)
//                .setReplace(false);
//
//        this.getOrCreateTagBuilder(PPEntityTypeTags.HUMANOID)
//                .add(WITCH)
//                .add(VILLAGER)
//                .add(PLAYER)
//                .setReplace(false);
    }
}
