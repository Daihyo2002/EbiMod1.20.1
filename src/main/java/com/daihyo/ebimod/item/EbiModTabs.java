package com.daihyo.ebimod.item;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class EbiModTabs {

    //レジストリ作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EbiMod.MOD_ID);

    //レジストリにタブを追加
    public static final RegistryObject<CreativeModeTab> EBIMOD_TAB = TABS.register("ebimod_tab" ,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(("creativetabs.ebimod_tab")))
                    .icon(EbiModItems.RAW_EBI.get()::getDefaultInstance)
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(EbiModItems.RAW_EBI.get());
                        pOutput.accept(EbiModBlocks.RAW_EBI_BLOCK.get());
                        pOutput.accept(EbiModItems.EBI_INGOT.get());
                        pOutput.accept(EbiModBlocks.EBI_BLOCK.get());
                        pOutput.accept(EbiModBlocks.EBI_ORE.get());
                        pOutput.accept(EbiModBlocks.DEEPSLATE_EBI_ORE.get());

                        pOutput.accept(EbiModBlocks.CURSED_LOG.get());
                        pOutput.accept(EbiModBlocks.STRIPPED_CURSED_LOG.get());
                        pOutput.accept(EbiModBlocks.CURSED_WOOD.get());
                        pOutput.accept(EbiModBlocks.STRIPPED_CURSED_WOOD.get());
                        pOutput.accept(EbiModBlocks.CURSED_LEAVES.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
