package com.daihyo.ebimod.datagen.server;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.tag.EbiModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EbiModBlockTagsProvider extends BlockTagsProvider {
    public EbiModBlockTagsProvider(PackOutput output,
                                   CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EbiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(EbiModBlocks.EBI_BLOCK.get(),
                          EbiModBlocks.RAW_EBI_BLOCK.get(),
                          EbiModBlocks.EBI_ORE.get(),
                          EbiModBlocks.DEEPSLATE_EBI_ORE.get());;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(EbiModBlocks.EBI_BLOCK.get(),
                        EbiModBlocks.EBI_ORE.get(),
                        EbiModBlocks.DEEPSLATE_EBI_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(EbiModBlocks.RAW_EBI_BLOCK.get());

        this.tag(EbiModTags.Blocks.CURSED_LOG)
                .add(EbiModBlocks.CURSED_LOG.get())
                .add(EbiModBlocks.CURSED_WOOD.get())
                .add(EbiModBlocks.STRIPPED_CURSED_LOG.get())
                .add(EbiModBlocks.STRIPPED_CURSED_WOOD.get());

        // 原木使用レシピ，地面判定，燃料
        this.tag(BlockTags.LOGS)
                .add(EbiModBlocks.CURSED_LOG.get())
                .add(EbiModBlocks.STRIPPED_CURSED_LOG.get());

        // 木炭になる
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(EbiModBlocks.CURSED_LOG.get())
                .add(EbiModBlocks.CURSED_WOOD.get())
                .add(EbiModBlocks.STRIPPED_CURSED_LOG.get())
                .add(EbiModBlocks.STRIPPED_CURSED_WOOD.get());

        this.tag(BlockTags.LEAVES)
                .add(EbiModBlocks.CURSED_LEAVES.get());



    }
}
