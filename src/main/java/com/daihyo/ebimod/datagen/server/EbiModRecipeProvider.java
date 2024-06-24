package com.daihyo.ebimod.datagen.server;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.block.EbiModBlocks;
import com.daihyo.ebimod.item.EbiModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class EbiModRecipeProvider extends RecipeProvider {

    // 精錬レシピ
    private static final List<ItemLike> EBI_SMALTABLE =
            List.of(EbiModItems.RAW_EBI.get(),
                    EbiModBlocks.EBI_ORE.get(),
                    EbiModBlocks.DEEPSLATE_EBI_ORE.get());

    public EbiModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    // pRecipeOutput = consumer
    // RecipeOutput = Consume<FinishedRecipe>
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        nineBlockStorageRecipes(consumer, RecipeCategory.MISC,
                EbiModItems.EBI_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                EbiModBlocks.EBI_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC,
                EbiModItems.RAW_EBI.get(),
                RecipeCategory.BUILDING_BLOCKS,
                EbiModBlocks.RAW_EBI_BLOCK.get());

        oreSmelting(consumer, EBI_SMALTABLE, RecipeCategory.MISC,
                EbiModItems.EBI_INGOT.get(),
                1.0f, 200, "ebi");

        oreBlasting(consumer, EBI_SMALTABLE, RecipeCategory.MISC,
                EbiModItems.EBI_INGOT.get(),
                1.0f, 100, "ebi");

        woodFromLogs(consumer, EbiModBlocks.CURSED_WOOD.get(),
                EbiModBlocks.CURSED_LOG.get());
        woodFromLogs(consumer, EbiModBlocks.STRIPPED_CURSED_WOOD.get(),
                EbiModBlocks.STRIPPED_CURSED_LOG.get());


    }

    // かまど
    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    // 溶鉱炉
    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    // 共通
    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        Iterator var9 = p_249619_.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_250791_,
                            EbiMod.MOD_ID + ":" + (p_250066_) + p_249236_ + "_" + getItemName(itemlike));
        }

    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_,
                                                  RecipeCategory p_250083_,
                                                  ItemLike p_250042_,
                                                  RecipeCategory p_248977_,
                                                  ItemLike p_251911_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9)
                .requires(p_251911_).unlockedBy(getHasName(p_251911_), has(p_251911_)).save(p_250423_);
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_)
                .pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_);
    }
}
