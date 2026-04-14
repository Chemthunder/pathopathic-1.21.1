package net.chemthunder.pathopathic.impl.block.entity;

import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.index.PPBlockEntities;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CauldronBlockEntity extends BlockEntity {
    private Disease heldDisease = PPDiseases.EMPTY;

    public CauldronBlockEntity(BlockPos pos, BlockState state) {
        super(PPBlockEntities.CAULDRON, pos, state);
    }

    public void updateListeners() {
        this.markDirty();
        if (this.world != null) {
            this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), Block.NOTIFY_ALL);
        }
    }

    public void tick(CauldronBlockEntity entity, World world, BlockPos pos, BlockState state) {
        Pathopathic.LOGGER.info(this.heldDisease.name());
    }

    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (nbt.contains("HeldDisease", NbtElement.COMPOUND_TYPE)) {
            NbtCompound compound = nbt.getCompound("HeldDisease");
            this.heldDisease = Disease.CODEC.parse(registryLookup.getOps(NbtOps.INSTANCE), compound).resultOrPartial(Pathopathic.LOGGER::error).orElseThrow();
        } else {
            this.heldDisease = PPDiseases.EMPTY;
        }
    }

    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (this.heldDisease != PPDiseases.EMPTY) {
            nbt.put("HeldDisease", Disease.CODEC.encodeStart(registryLookup.getOps(NbtOps.INSTANCE), this.heldDisease).getOrThrow());
        }
    }

    public void setHeldDisease(Disease disease) {
        this.heldDisease = disease;
        this.updateListeners();
    }

    public Disease getHeldDisease() {
        return this.heldDisease;
    }
}
