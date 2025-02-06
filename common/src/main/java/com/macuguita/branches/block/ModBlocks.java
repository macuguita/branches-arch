package com.macuguita.branches.block;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.custom.BranchBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.macuguita.branches.Branches.MOD_ID;

public class ModBlocks {

    public static final Block ACACIA_BRANCH = createBranch("acacia_branch", Blocks.ACACIA_LOG);
    public static final Block STRIPPED_ACACIA_BRANCH = createBranch("stripped_acacia_branch", Blocks.STRIPPED_ACACIA_WOOD);

    public static final Block BIRCH_BRANCH = createBranch("birch_branch", Blocks.BIRCH_LOG);
    public static final Block STRIPPED_BIRCH_BRANCH = createBranch("stripped_birch_branch", Blocks.STRIPPED_BIRCH_LOG);

    public static final Block CHERRY_BRANCH = createBranch("cherry_branch", Blocks.CHERRY_LOG);
    public static final Block STRIPPED_CHERRY_BRANCH = createBranch("stripped_cherry_branch", Blocks.STRIPPED_CHERRY_LOG);

    public static final Block DARK_OAK_BRANCH = createBranch("dark_oak_branch", Blocks.DARK_OAK_LOG);
    public static final Block STRIPPED_DARK_OAK_BRANCH = createBranch("stripped_dark_oak_branch", Blocks.STRIPPED_DARK_OAK_LOG);

    public static final Block JUNGLE_BRANCH = createBranch("jungle_branch", Blocks.JUNGLE_LOG);
    public static final Block STRIPPED_JUNGLE_BRANCH = createBranch("stripped_jungle_branch", Blocks.STRIPPED_JUNGLE_LOG);

    public static final Block MANGROVE_BRANCH = createBranch("mangrove_branch", Blocks.MANGROVE_LOG);
    public static final Block STRIPPED_MANGROVE_BRANCH = createBranch("stripped_mangrove_branch", Blocks.STRIPPED_MANGROVE_LOG);

    public static final Block OAK_BRANCH = createBranch("oak_branch", Blocks.OAK_LOG);
    public static final Block STRIPPED_OAK_BRANCH = createBranch("stripped_oak_branch", Blocks.STRIPPED_OAK_LOG);

    public static final Block SPRUCE_BRANCH = createBranch("spruce_branch", Blocks.SPRUCE_LOG);
    public static final Block STRIPPED_SPRUCE_BRANCH = createBranch("stripped_spruce_branch", Blocks.STRIPPED_SPRUCE_LOG);

    public static final Block CRIMSON_STIPE = createBranch("crimson_stipe", Blocks.CRIMSON_STEM);
    public static final Block STRIPPED_CRIMSON_STIPE = createBranch("stripped_crimson_stipe", Blocks.STRIPPED_CRIMSON_STEM);

    public static final Block WARPED_STIPE = createBranch("warped_stipe", Blocks.WARPED_STEM);
    public static final Block STRIPPED_WARPED_STIPE = createBranch("stripped_warped_stipe", Blocks.STRIPPED_WARPED_STEM);

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );
    }

    public static void registerModBlocks() {
        Branches.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }

    private static Block createBranch(String name, Block wood) {
        return registerBlock(name, new BranchBlock(AbstractBlock.Settings.copy(wood).mapColor(wood.getDefaultMapColor())));
    }
}
