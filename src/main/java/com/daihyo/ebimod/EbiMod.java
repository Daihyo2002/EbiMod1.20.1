package com.daihyo.ebimod;

import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.item.EbiModItems;
import com.daihyo.ebimod.item.EbiModTabs;
import com.daihyo.ebimod.loot.EbiModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EbiMod.MOD_ID)
public class EbiMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ebimod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public EbiMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // アイテムレジストリをイベントバスに登録
        EbiModItems.register(modEventBus);

        // クリエイティブタブレジストリをイベントバスに登録
        EbiModTabs.register(modEventBus);

        // ブロックレジストリをイベントバスに登録
        EbiModBlocks.register(modEventBus);

        // GlobalLootModifierをイベントバスに登録
        EbiModLootModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        //クリエイティブタブにアイテムを追加
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){

            //追加アイテム名
            event.accept(EbiModItems.RAW_EBI);
            event.accept(EbiModItems.EBI_INGOT);
            event.accept(EbiModBlocks.EBI_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
