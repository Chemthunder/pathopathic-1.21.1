package net.chemthunder.pathopathic.impl.entity;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.index.PPBlockEntities;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PathoCauldronBlockEntity extends BlockEntity {
    private Disease heldDisease = Disease.EMPTY;

    public PathoCauldronBlockEntity(BlockPos pos, BlockState state) {
        super(PPBlockEntities.PATHO_CAULDRON, pos, state);
    }

    public void tick(PathoCauldronBlockEntity entity, World world, BlockPos pos, BlockState state) {
        Pathopathic.LOGGER.info(this.heldDisease.name());
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (nbt.contains("HeldDisease", NbtElement.COMPOUND_TYPE)) {
            NbtCompound compound = nbt.getCompound("HeldDisease");
            this.heldDisease = Disease.CODEC.parse(registryLookup.getOps(NbtOps.INSTANCE), compound).resultOrPartial(Pathopathic.LOGGER::error).orElseThrow();
        } else {
            this.heldDisease = Disease.EMPTY;
        }
        super.readNbt(nbt, registryLookup);
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (this.heldDisease != Disease.EMPTY) {
            nbt.put("HeldDisease", Disease.CODEC.encodeStart(registryLookup.getOps(NbtOps.INSTANCE), this.heldDisease).getOrThrow());
        }
        super.writeNbt(nbt, registryLookup);
    }

    public void setHeldDisease(Disease disease) {
        this.heldDisease = disease;
        this.markDirty();
    }

    public Disease getHeldDisease() {
        return this.heldDisease;
    }
}
