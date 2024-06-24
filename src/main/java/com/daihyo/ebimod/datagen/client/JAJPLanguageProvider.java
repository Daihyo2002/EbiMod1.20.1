package com.daihyo.ebimod.datagen.client;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.item.EbiModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, EbiMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {

        addItem(EbiModItems.RAW_EBI, "えびの原石");
        addItem(EbiModItems.EBI_INGOT, "えびインゴット");

        add("creativetabs.ebimod_tab", "えびMOD");

        addBlock(EbiModBlocks.EBI_BLOCK, "えびブロック");
        addBlock(EbiModBlocks.RAW_EBI_BLOCK, "えびの原石ブロック");
        addBlock(EbiModBlocks.EBI_ORE, "えび鉱石");
        addBlock(EbiModBlocks.DEEPSLATE_EBI_ORE, "深層えび鉱石");
        addBlock(EbiModBlocks.CURSED_LOG, "呪われた原木");
        addBlock(EbiModBlocks.STRIPPED_CURSED_LOG, "樹皮を剥いだ呪われた原木");
        addBlock(EbiModBlocks.CURSED_WOOD, "呪われた木");
        addBlock(EbiModBlocks.STRIPPED_CURSED_WOOD, "樹皮を剥いだ呪われた木");
        addBlock(EbiModBlocks.CURSED_LEAVES, "呪われた葉");
    }
}
