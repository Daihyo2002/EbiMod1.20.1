package com.daihyo.ebimod.loot;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ReplaceItemModifier extends LootModifier {


    public static final Supplier<Codec<ReplaceItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec()
            .fieldOf("item").forGetter(m -> m.item))
            .and(Codec.FLOAT.fieldOf("chance").forGetter(m -> m.chance))
            .apply(inst, ReplaceItemModifier::new)));

    private final Item item;
    private final float chance;


    public ReplaceItemModifier(LootItemCondition[] conditionsIn, Item item, float chance) {
        super(conditionsIn);

        this.item = item;
        this.chance = chance;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> objectArrayList, LootContext lootContext) {

        // context = lootContext
        // generatedLoot = objectArrayList

        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(lootContext)) {
                return objectArrayList;
            }
        }

        if (lootContext.getRandom().nextFloat() < chance) {
            objectArrayList.clear();
            objectArrayList.add(new ItemStack(this.item));
        }

        return objectArrayList;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
