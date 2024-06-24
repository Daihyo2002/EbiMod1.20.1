package com.daihyo.ebimod.datagen;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.datagen.client.ENUSLanguageProvider;
import com.daihyo.ebimod.datagen.client.EbiModBlockStateProvider;
import com.daihyo.ebimod.datagen.client.EbiModItemModelProvider;
import com.daihyo.ebimod.datagen.client.JAJPLanguageProvider;
import com.daihyo.ebimod.datagen.server.*;
import com.daihyo.ebimod.datagen.server.loot.EbiModLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = EbiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EbiModDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        // アイテム用モデルファイルの自動生成
        generator.addProvider(event.includeClient(),
                new EbiModItemModelProvider(packOutput, existingFileHelper));

        // ブロック 々
        generator.addProvider(event.includeClient(),
                new EbiModBlockStateProvider(packOutput, existingFileHelper));

        // 言語 々
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        // レシピ 々
        generator.addProvider(event.includeServer(), new EbiModRecipeProvider(packOutput));

        // ルートテーブル 々
        generator.addProvider(event.includeServer(), EbiModLootTables.create(packOutput));

        // ブロックタグ 々
        var blockTagsProvider = generator.addProvider(event.includeServer(),
                new EbiModBlockTagsProvider(packOutput, lookUpProvider, existingFileHelper));

        // アイテムタグ 々
        generator.addProvider(event.includeServer(),
                new EbiModItemTagsProvider(packOutput, lookUpProvider,
                        blockTagsProvider.contentsGetter(), existingFileHelper));

        // GlobalLootModifier
        generator.addProvider(event.includeServer(),
                new EbiModGlobalLootModifierProvider(packOutput));

        // WorldGenProvider
        generator.addProvider(event.includeServer(),
                new EbiModWorldGenProvider(packOutput, lookUpProvider));

    }
}
