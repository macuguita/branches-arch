package com.macuguita.branches;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.block.custom.BranchBlock;
import com.macuguita.branches.item.ModItemGroups;
import dev.architectury.registry.fuel.FuelRegistry;
import net.minecraft.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Branches {
    public static final String MOD_ID = "branches";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        ModBlocks.registerModBlocks();
        ModItemGroups.registerModItemGroups();
    }

    public static void commonSetup() {
        try {
            mapVanillaBranches();
            registerFuels();
        } catch (Exception e) {
            Branches.LOGGER.error("Failed to map branches and register them as fuels", e);
        }
    }

    private static void mapVanillaBranches() {
        strippedMapper(ModBlocks.ACACIA_BRANCH.get(), ModBlocks.STRIPPED_ACACIA_BRANCH.get());
        strippedMapper(ModBlocks.BIRCH_BRANCH.get(), ModBlocks.STRIPPED_BIRCH_BRANCH.get());
        strippedMapper(ModBlocks.CHERRY_BRANCH.get(), ModBlocks.STRIPPED_CHERRY_BRANCH.get());
        strippedMapper(ModBlocks.DARK_OAK_BRANCH.get(), ModBlocks.STRIPPED_DARK_OAK_BRANCH.get());
        strippedMapper(ModBlocks.JUNGLE_BRANCH.get(), ModBlocks.STRIPPED_JUNGLE_BRANCH.get());
        strippedMapper(ModBlocks.MANGROVE_BRANCH.get(), ModBlocks.STRIPPED_MANGROVE_BRANCH.get());
        strippedMapper(ModBlocks.OAK_BRANCH.get(), ModBlocks.STRIPPED_OAK_BRANCH.get());
        strippedMapper(ModBlocks.SPRUCE_BRANCH.get(), ModBlocks.STRIPPED_SPRUCE_BRANCH.get());
        strippedMapper(ModBlocks.CRIMSON_STIPE.get(), ModBlocks.STRIPPED_CRIMSON_STIPE.get());
        strippedMapper(ModBlocks.WARPED_STIPE.get(), ModBlocks.STRIPPED_WARPED_STIPE.get());
    }

    private static void registerFuels() {
        FuelRegistry.register(37, ModBlocks.ACACIA_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_ACACIA_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.BIRCH_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_BIRCH_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.CHERRY_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_CHERRY_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.DARK_OAK_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_DARK_OAK_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.JUNGLE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_JUNGLE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.MANGROVE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_MANGROVE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.OAK_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_OAK_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.SPRUCE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_SPRUCE_BRANCH.get());
        FuelRegistry.register(37, ModBlocks.CRIMSON_STIPE.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_CRIMSON_STIPE.get());
        FuelRegistry.register(37, ModBlocks.WARPED_STIPE.get());
        FuelRegistry.register(37, ModBlocks.STRIPPED_WARPED_STIPE.get());
    }

    public static void strippedMapper(Block branch, Block strippedBranch) {
        BranchBlock.STRIPPED_BRANCHES.put(branch, strippedBranch);
    }
}
