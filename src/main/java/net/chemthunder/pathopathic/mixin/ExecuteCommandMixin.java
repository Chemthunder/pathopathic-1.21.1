package net.chemthunder.pathopathic.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.tree.CommandNode;
import net.chemthunder.pathopathic.impl.Pathopathic;
import net.chemthunder.pathopathic.impl.cca.entity.DiseaseComponent;
import net.chemthunder.pathopathic.impl.index.PPDiseases;
import net.chemthunder.pathopathic.impl.index.PPRegistries;
import net.chemthunder.pathopathic.impl.util.disease.Disease;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.suggestion.SuggestionProviders;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.command.ExecuteCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

@Mixin(ExecuteCommand.class)
public abstract class ExecuteCommandMixin {
    @Unique
    private static final SuggestionProvider<ServerCommandSource> ALL_DISEASES = SuggestionProviders.register(Pathopathic.id("all_diseases"),
            (context, builder) -> CommandSource.suggestFromIdentifier(
                    PPRegistries.DISEASE.stream(),
                    builder,
                    Disease::getId,
                    disease -> Text.translatable(disease.getTranslationKey())
            )
    );

    @Shadow
    private static ArgumentBuilder<ServerCommandSource, ?> addConditionLogic(CommandNode<ServerCommandSource> root, ArgumentBuilder<ServerCommandSource, ?> builder, boolean positive, ExecuteCommand.Condition condition) {
        throw new AssertionError();
    }

    @Unique
    private static boolean hasDisease(String name, Entity entity) {
        Disease disease = PPRegistries.DISEASE.getOrEmpty(Identifier.of(name)).orElse(PPDiseases.EMPTY);
        if (entity instanceof LivingEntity living) {
            DiseaseComponent component = DiseaseComponent.KEY.get(living);
            return component.getDisease() == disease;
        }

        return false;
    }

    @ModifyReturnValue(method = "addConditionArguments", at = @At("RETURN"))
    private static ArgumentBuilder<ServerCommandSource, ?> acornlib$addArguments(
            ArgumentBuilder<ServerCommandSource, ?> original,
            CommandNode<ServerCommandSource> root,
            LiteralArgumentBuilder<ServerCommandSource> argumentBuilder,
            boolean positive,
            CommandRegistryAccess commandRegistryAccess
    ) {
        original.then(literal("disease")
                .then(argument("target", EntityArgumentType.entity())
                        .then(
                                addConditionLogic(
                                        root,
                                        argument("disease", StringArgumentType.string()).suggests(ALL_DISEASES),
                                        positive,
                                        context -> hasDisease(
                                                StringArgumentType.getString(context, "disease"),
                                                EntityArgumentType.getEntity(context, "target")
                                        )
                                )
                        )
                )
        );

        return original;
    }
}
