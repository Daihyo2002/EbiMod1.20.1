package com.daihyo.ebimod.datagen.client;

import com.daihyo.ebimod.EbiMod;
import com.daihyo.ebimod.item.EbiModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class EbiModItemModelProvider extends ItemModelProvider {
    public EbiModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EbiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(EbiModItems.RAW_EBI.get());
        basicItem(EbiModItems.EBI_INGOT.get());

    }
}
