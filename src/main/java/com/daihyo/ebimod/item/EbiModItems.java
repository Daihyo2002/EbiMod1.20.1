package com.daihyo.ebimod.item;

import com.daihyo.ebimod.EbiMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EbiModItems {

    // レジストリ作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EbiMod.MOD_ID);

    // レジストリにアイテムを追加
    public static final RegistryObject<Item> RAW_EBI = ITEMS.register("raw_ebi", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EBI_INGOT = ITEMS.register("ebi_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);
    }
}
