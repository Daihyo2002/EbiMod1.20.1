package com.daihyo.ebimod.worldgen.features;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class EbiModOreFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBI_ORE_KEY =
            createKey("ebi_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> ebiOres = List.of(
                OreConfiguration.target(stone,
                        EbiModBlocks.EBI_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate,
                        EbiModBlocks.DEEPSLATE_EBI_ORE.get().defaultBlockState())

        );

        FeatureUtils.register(context, EBI_ORE_KEY, Feature.ORE,
                new OreConfiguration(ebiOres, 9));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                new ResourceLocation(EbiMod.MOD_ID, name));
    }
}
