package com.daihyo.ebimod.datagen.server;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.worldgen.biome.EbiModBiomeModifiers;
import com.daihyo.ebimod.worldgen.features.EbiModOreFeatures;
import com.daihyo.ebimod.worldgen.placement.EbiModOrePlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EbiModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, EbiModOreFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, EbiModOrePlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, EbiModBiomeModifiers::bootstrap);


    public EbiModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(EbiMod.MOD_ID));
    }

}
