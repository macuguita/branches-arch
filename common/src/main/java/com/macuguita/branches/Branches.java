package com.macuguita.branches;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.block.custom.BranchBlock;
import dev.architectury.registry.fuel.FuelRegistry;
import net.minecraft.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Branches {
    public static final String MOD_ID = "branches";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        ModBlocks.registerModBlocks();
        mapVanillaBranches();
        registerFuels();
    }

    private static void mapVanillaBranches() {
        strippedMapper(ModBlocks.ACACIA_BRANCH, ModBlocks.STRIPPED_ACACIA_BRANCH);
        strippedMapper(ModBlocks.BIRCH_BRANCH, ModBlocks.STRIPPED_BIRCH_BRANCH);
        strippedMapper(ModBlocks.CHERRY_BRANCH, ModBlocks.STRIPPED_CHERRY_BRANCH);
        strippedMapper(ModBlocks.DARK_OAK_BRANCH, ModBlocks.STRIPPED_DARK_OAK_BRANCH);
        strippedMapper(ModBlocks.JUNGLE_BRANCH, ModBlocks.STRIPPED_JUNGLE_BRANCH);
        strippedMapper(ModBlocks.MANGROVE_BRANCH, ModBlocks.STRIPPED_MANGROVE_BRANCH);
        strippedMapper(ModBlocks.OAK_BRANCH, ModBlocks.STRIPPED_OAK_BRANCH);
        strippedMapper(ModBlocks.SPRUCE_BRANCH, ModBlocks.STRIPPED_SPRUCE_BRANCH);
        strippedMapper(ModBlocks.CRIMSON_STIPE, ModBlocks.STRIPPED_CRIMSON_STIPE);
        strippedMapper(ModBlocks.WARPED_STIPE, ModBlocks.STRIPPED_WARPED_STIPE);
    }
    private static void registerFuels() {
        FuelRegistry.register(37, ModBlocks.ACACIA_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_ACACIA_BRANCH);
        FuelRegistry.register(37, ModBlocks.BIRCH_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_BIRCH_BRANCH);
        FuelRegistry.register(37, ModBlocks.CHERRY_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_CHERRY_BRANCH);
        FuelRegistry.register(37, ModBlocks.DARK_OAK_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_DARK_OAK_BRANCH);
        FuelRegistry.register(37, ModBlocks.JUNGLE_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_JUNGLE_BRANCH);
        FuelRegistry.register(37, ModBlocks.MANGROVE_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_MANGROVE_BRANCH);
        FuelRegistry.register(37, ModBlocks.OAK_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_OAK_BRANCH);
        FuelRegistry.register(37, ModBlocks.SPRUCE_BRANCH);
        FuelRegistry.register(37, ModBlocks.STRIPPED_SPRUCE_BRANCH);
        FuelRegistry.register(37, ModBlocks.CRIMSON_STIPE);
        FuelRegistry.register(37, ModBlocks.STRIPPED_CRIMSON_STIPE);
        FuelRegistry.register(37, ModBlocks.WARPED_STIPE);
        FuelRegistry.register(37, ModBlocks.STRIPPED_WARPED_STIPE);

    }
    
    public static void strippedMapper(Block branch, Block strippedBranch) {
        BranchBlock.STRIPPED_BRANCHES.put(branch, strippedBranch);
    }
}
