package net.chemthunder.pathopathic.impl.symptom;

import net.chemthunder.pathopathic.impl.util.disease.Symptom;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CancerousSymptom extends Symptom {
    public CancerousSymptom(String name) {
        super(name);
    }

    public void getTickingEffect(LivingEntity living) {
        World world = living.getWorld();
        Random random = world.getRandom();

        if (random.nextBetween(0, 8) >= 6) {
            living.damage(living.getDamageSources().generic(), 1.0f);
        }

        super.getTickingEffect(living);
    }
}