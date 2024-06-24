package com.daihyo.ebimod.datagen.client;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.item.EbiModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {

    public ENUSLanguageProvider(PackOutput output) {
        super(output, EbiMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {

        addItem(EbiModItems.RAW_EBI, "Raw Ebi");
        addItem(EbiModItems.EBI_INGOT, "Ebi Ingot");

        add("creativetabs.ebimod_tab", "Ebi MOD");

        addBlock(EbiModBlocks.EBI_BLOCK, "Ebi Block");
        addBlock(EbiModBlocks.RAW_EBI_BLOCK, "Raw Ebi Block");
        addBlock(EbiModBlocks.EBI_ORE, "Ebi Ore");
        addBlock(EbiModBlocks.DEEPSLATE_EBI_ORE, "Deepslate Ebi Ore");
        addBlock(EbiModBlocks.CURSED_LOG, "Cursed Log");
        addBlock(EbiModBlocks.STRIPPED_CURSED_LOG, "Stripped Cursed Log");
        addBlock(EbiModBlocks.CURSED_WOOD, "Cursed Wood");
        addBlock(EbiModBlocks.STRIPPED_CURSED_WOOD, "Stripped Cursed Wood");
        addBlock(EbiModBlocks.CURSED_LEAVES, "Cursed Leaves");
    }
}
