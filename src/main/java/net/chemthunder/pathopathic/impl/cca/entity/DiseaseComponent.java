package net.chemthunder.pathopathic.impl.cca.entity;

import net.acoyt.acornlib.api.util.MiscUtils;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class DiseaseComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<DiseaseComponent> KEY = MiscUtils.getOrCreateKey(Pathopathic.id("disease"), DiseaseComponent.class);
    private final PlayerEntity living;

    private Disease disease = PPDiseases.EMPTY;
    private int duration = 0;

    public DiseaseComponent(PlayerEntity living) {
        this.living = living;
    }

    public void sync() {
        KEY.sync(this.living);
    }

    public void tick() {
        if (!this.living.getWorld().isClient()) {
            if (!this.disease.isEmpty()) {
                this.sync();
            }
        }

        if (this.duration > 0) {
            this.duration--;
            if (this.duration == 0) {
                this.setDisease(PPDiseases.EMPTY);
                this.sync();
            }
        }
    }

    public Disease getDisease() {
        return this.disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
        this.sync();
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        this.sync();
    }

    public void setDisease(Disease disease, int duration) {
        this.disease = disease;
        this.duration = duration;

        if (!this.living.getWorld().isClient()) {
            this.sync();
        }
    }

    public void readFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        this.duration = nbt.getInt("Duration");

        if (nbt.contains("Disease", NbtElement.COMPOUND_TYPE)) {
            NbtCompound compound = nbt.getCompound("Disease");
            this.disease = Disease.CODEC.parse(wrapperLookup.getOps(NbtOps.INSTANCE), compound).resultOrPartial(Pathopathic.LOGGER::error).orElseThrow();
        } else {
            this.disease = PPDiseases.EMPTY;
        }
    }

    public void writeToNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup wrapperLookup) {
        nbt.putInt("Duration", duration);

        if (this.disease != PPDiseases.EMPTY) {
            nbt.put("Disease", Disease.CODEC.encodeStart(wrapperLookup.getOps(NbtOps.INSTANCE), this.disease).getOrThrow());
        }
    }
}
