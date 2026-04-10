package net.chemthunder.pathopathic.impl.cca;

import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.minecraft.entity.LivingEntity;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class PPComponents implements EntityComponentInitializer {
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(LivingEntity.class, DiseaseComponent.KEY).respawnStrategy(RespawnCopyStrategy.NEVER_COPY).end(DiseaseComponent::new);
    }
}
