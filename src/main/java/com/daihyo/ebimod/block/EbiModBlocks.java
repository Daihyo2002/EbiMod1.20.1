package com.daihyo.ebimod.block;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.custom.EbiModLeavesBlock;
import com.daihyo.ebimod.block.custom.EbiModLogBlock;
import com.daihyo.ebimod.block.custom.EbiModStrippableLogBlock;
import com.daihyo.ebimod.item.EbiModItems;
import com.google.common.base.Supplier;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EbiModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EbiMod.MOD_ID);

    public static final RegistryObject<Block> EBI_BLOCK = registerBlockItem("ebi_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.LANTERN)));

    public static final RegistryObject<Block> RAW_EBI_BLOCK = registerBlockItem("raw_ebi_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> EBI_ORE = registerBlockItem("ebi_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> DEEPSLATE_EBI_ORE = registerBlockItem("deepslate_ebi_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE),
                    UniformInt.of(4, 6)));


    public static final RegistryObject<Block> STRIPPED_CURSED_LOG = registerBlockItem("stripped_cursed_log",
            () -> new EbiModLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> STRIPPED_CURSED_WOOD = registerBlockItem("stripped_cursed_wood",
            () -> new EbiModLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> CURSED_LOG = registerBlockItem("cursed_log",
            () -> new EbiModStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_LOG));

    public static final RegistryObject<Block> CURSED_WOOD = registerBlockItem("cursed_wood",
            () -> new EbiModStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.BONE_BLOCK),
                    STRIPPED_CURSED_WOOD));

    public static final RegistryObject<Block> CURSED_LEAVES = registerBlockItem("cursed_leaves",
            () -> new EbiModLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));




    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        EbiModItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }



    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
