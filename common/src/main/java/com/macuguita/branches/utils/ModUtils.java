package com.macuguita.branches.utils;

import com.macuguita.branches.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ModUtils {

    public static Block getStrippedBranchBlock(Block branch) {
        if (branch.equals(ModBlocks.OAK_BRANCH)) {
            return ModBlocks.STRIPPED_OAK_BRANCH;
        } else if (branch.equals(ModBlocks.BIRCH_BRANCH)) {
            return ModBlocks.STRIPPED_BIRCH_BRANCH;
        } else if (branch.equals(ModBlocks.SPRUCE_BRANCH)) {
            return ModBlocks.STRIPPED_SPRUCE_BRANCH;
        } else if (branch.equals(ModBlocks.JUNGLE_BRANCH)) {
            return ModBlocks.STRIPPED_JUNGLE_BRANCH;
        } else if (branch.equals(ModBlocks.DARK_OAK_BRANCH)) {
            return ModBlocks.STRIPPED_DARK_OAK_BRANCH;
        } else if (branch.equals(ModBlocks.ACACIA_BRANCH)) {
            return ModBlocks.STRIPPED_ACACIA_BRANCH;
        } else if (branch.equals(ModBlocks.MANGROVE_BRANCH)) {
            return ModBlocks.STRIPPED_MANGROVE_BRANCH;
        } else if (branch.equals(ModBlocks.CHERRY_BRANCH)) {
            return ModBlocks.STRIPPED_CHERRY_BRANCH;
        } else if (branch.equals(ModBlocks.CRIMSON_STIPE)) {
            return ModBlocks.STRIPPED_CRIMSON_STIPE;
        } else if (branch.equals(ModBlocks.WARPED_STIPE)) {
            return ModBlocks.STRIPPED_WARPED_STIPE;
        }
        return branch;
    }

    public static Block getStrippedLogBlock(Block log) {
        if (log.equals(Blocks.OAK_LOG)) {
            return Blocks.STRIPPED_OAK_LOG;
        } else if (log.equals(Blocks.BIRCH_LOG)) {
            return Blocks.STRIPPED_BIRCH_LOG;
        } else if (log.equals(Blocks.SPRUCE_LOG)) {
            return Blocks.STRIPPED_SPRUCE_LOG;
        } else if (log.equals(Blocks.JUNGLE_LOG)) {
            return Blocks.STRIPPED_JUNGLE_LOG;
        } else if (log.equals(Blocks.DARK_OAK_LOG)) {
            return Blocks.STRIPPED_DARK_OAK_LOG;
        } else if (log.equals(Blocks.ACACIA_LOG)) {
            return Blocks.STRIPPED_ACACIA_LOG;
        } else if (log.equals(Blocks.MANGROVE_LOG)) {
            return Blocks.STRIPPED_MANGROVE_LOG;
        } else if (log.equals(Blocks.CHERRY_LOG)) {
            return Blocks.STRIPPED_CHERRY_LOG;
        } else if (log.equals(Blocks.CRIMSON_STEM)) {
            return Blocks.STRIPPED_CRIMSON_STEM;
        } else if (log.equals(Blocks.WARPED_STEM)) {
            return Blocks.STRIPPED_WARPED_STEM;
        }
        return log;
    }
}
