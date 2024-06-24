package com.daihyo.ebimod.block.custom;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

// 原木，木
public class EbiModStrippableLogBlock extends EbiModLogBlock{

    private final RegistryObject<Block> strippedLog;

    public EbiModStrippableLogBlock(Properties p_55926_, RegistryObject<Block> strippedLog) {
        super(p_55926_);
        this.strippedLog = strippedLog;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {

        // 斧Rクリック，樹皮を剥ぐ
        if (toolAction == ToolActions.AXE_STRIP) {
            return strippedLog.get().defaultBlockState()
                    .setValue(AXIS, state.getValue(AXIS));
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
