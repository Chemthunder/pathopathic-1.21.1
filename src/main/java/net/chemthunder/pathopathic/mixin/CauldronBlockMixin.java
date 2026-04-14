package net.chemthunder.pathopathic.mixin;

import net.chemthunder.pathopathic.impl.block.entity.CauldronBlockEntity;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractCauldronBlock.class)
public abstract class CauldronBlockMixin extends Block implements BlockEntityProvider {
    public CauldronBlockMixin(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CauldronBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World nullWorld, BlockState nullState, BlockEntityType<T> type) {
        return (world, pos, state, blockEntity) -> {
            if (blockEntity instanceof CauldronBlockEntity cauldronBlock) {
                cauldronBlock.tick(cauldronBlock, world, pos, state);
            }
        };
    }
}
