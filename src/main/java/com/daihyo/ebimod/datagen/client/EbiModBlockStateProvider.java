package com.daihyo.ebimod.datagen.client;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EbiModBlockStateProvider extends BlockStateProvider {
    public EbiModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, EbiMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlockWithItem(EbiModBlocks.EBI_BLOCK);
        simpleBlockWithItem(EbiModBlocks.RAW_EBI_BLOCK);
        simpleBlockWithItem(EbiModBlocks.EBI_ORE);
        simpleBlockWithItem(EbiModBlocks.DEEPSLATE_EBI_ORE);

        logBlock((RotatedPillarBlock) EbiModBlocks.CURSED_LOG.get());
        logBlock((RotatedPillarBlock) EbiModBlocks.STRIPPED_CURSED_LOG.get());
        axisBlock((RotatedPillarBlock) EbiModBlocks.CURSED_WOOD.get(),
                blockTexture(EbiModBlocks.CURSED_LOG.get()),
                blockTexture(EbiModBlocks.CURSED_LOG.get()));
        axisBlock((RotatedPillarBlock) EbiModBlocks.STRIPPED_CURSED_WOOD.get(),
                blockTexture(EbiModBlocks.STRIPPED_CURSED_LOG.get()),
                blockTexture(EbiModBlocks.STRIPPED_CURSED_LOG.get()));
        item(EbiModBlocks.CURSED_LOG);
        item(EbiModBlocks.STRIPPED_CURSED_LOG);
        item(EbiModBlocks.CURSED_WOOD);
        item(EbiModBlocks.STRIPPED_CURSED_WOOD);
        cursedLeaves(EbiModBlocks.CURSED_LEAVES);

    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                EbiMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 呪われた葉ブロック
    private void cursedLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeTop(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                TextureMapping.getBlockTexture(block.get(), "_side"),
                TextureMapping.getBlockTexture(block.get(), "_top")
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("minecraft:block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }
}
