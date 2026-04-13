package net.chemthunder.pathopathic.data.provider;

import net.chemthunder.pathopathic.impl.index.PPItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class PPModelGen extends FabricModelProvider {
    public PPModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(PPItems.WRAPPED_STICK, Models.HANDHELD);
        itemModelGenerator.register(PPItems.FOUL_POUCH, Models.GENERATED);
    }
}
