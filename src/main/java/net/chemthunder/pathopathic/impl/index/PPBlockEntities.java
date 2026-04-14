package net.chemthunder.pathopathic.impl.index;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.block.entity.CauldronBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

@SuppressWarnings("deprecation")
public interface PPBlockEntities {
    BlockEntityType<CauldronBlockEntity> CAULDRON = create("cauldron", FabricBlockEntityTypeBuilder
            .create(CauldronBlockEntity::new, Blocks.CAULDRON, Blocks.WATER_CAULDRON, Blocks.LAVA_CAULDRON, Blocks.POWDER_SNOW_CAULDRON));

    private static <T extends BlockEntity> BlockEntityType<T> create(String name, FabricBlockEntityTypeBuilder<T> builder) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Pathopathic.id(name), builder.build());
    }

    static void init() {}

    static void clientInit() {}
}
