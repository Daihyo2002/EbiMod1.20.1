package com.daihyo.ebimod.datagen.server;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.item.EbiModItems;
import com.daihyo.ebimod.loot.AddItemModifier;
import com.daihyo.ebimod.loot.ReplaceItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class EbiModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public EbiModGlobalLootModifierProvider(PackOutput output) {
        super(output, EbiMod.MOD_ID);
    }

    @Override
    protected void start() {

        // 荒廃したポータルチェスト
        add("ebi_ingot_from_ruined_portal", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build()
        }, EbiModItems.EBI_INGOT.get()));

        // ゾンビドロップ
        add("ebi_ingot_from_zombie", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()
        }, EbiModItems.EBI_INGOT.get()));

        // スニッファーの掘り出し物
        add("ebi_ingot_from_sniffer_digging", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/sniffer_digging")).build()
        }, EbiModItems.EBI_INGOT.get(), 0.5f));

        // 怪しげな砂ドロップ
        add("ebi_ingot_from_sus_sand", new ReplaceItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build()
        }, EbiModItems.EBI_INGOT.get(), 0.5f));

    }
}
