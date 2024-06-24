package com.daihyo.ebimod.datagen.server.loot;

import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.item.EbiModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class EbiModBlockLootTables extends BlockLootSubProvider {
    protected EbiModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(EbiModBlocks.EBI_BLOCK.get());
        this.dropSelf(EbiModBlocks.RAW_EBI_BLOCK.get());

        this.add(EbiModBlocks.EBI_ORE.get(),
                block -> this.createOreDrop(block, EbiModItems.RAW_EBI.get()));
        this.add(EbiModBlocks.DEEPSLATE_EBI_ORE.get(),
                block -> this.createOreDrop(block, EbiModItems.RAW_EBI.get()));

        this.dropSelf(EbiModBlocks.CURSED_LOG.get());
        this.dropSelf(EbiModBlocks.STRIPPED_CURSED_LOG.get());
        this.dropSelf(EbiModBlocks.CURSED_WOOD.get());
        this.dropSelf(EbiModBlocks.STRIPPED_CURSED_WOOD.get());

        // TODO:苗木に変更
        this.add(EbiModBlocks.CURSED_LEAVES.get(),
                block -> createLeavesDrops(block, EbiModBlocks.EBI_BLOCK.get(),
                        NORMAL_LEAVES_SAPLING_CHANCES));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return EbiModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
