package net.chemthunder.pathopathic.impl.cca.entity;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class DiseaseComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<DiseaseComponent> KEY = MiscUtils.getOrCreateKey(Pathopathic.id("disease"), DiseaseComponent.class);

    private final LivingEntity living;
    public void sync() {
        KEY.sync(living);
    }

    private Disease disease = Disease.EMPTY;

    private int duration = 0;

    public DiseaseComponent(LivingEntity living) {
        this.living = living;
    }

    public void tick() {
        if (this.duration > 0) {
            duration--;
            if (duration == 0) {
                setDisease(Disease.EMPTY);
                sync();
            }
        }
    }

    public Disease getDisease() {
        return this.disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
        sync();
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        sync();
    }

    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.duration = nbtCompound.getInt("Duration");

        if (nbtCompound.contains("Disease", NbtElement.COMPOUND_TYPE)) {
            NbtCompound compound = nbtCompound.getCompound("Disease");
            this.disease = Disease.CODEC.parse(wrapperLookup.getOps(NbtOps.INSTANCE), compound).resultOrPartial(Pathopathic.LOGGER::error).orElseThrow();
        } else {
            this.disease = null;
        }
    }

    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbtCompound.putInt("Duration", duration);

        if (this.disease != null) {
            nbtCompound.put("Disease", Disease.CODEC.encodeStart(wrapperLookup.getOps(NbtOps.INSTANCE), this.disease).getOrThrow());
        }
    }
}