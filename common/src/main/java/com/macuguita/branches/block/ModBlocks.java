package com.macuguita.branches.block;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.custom.BranchBlock;
import com.macuguita.branches.utils.RegUtils;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

import static com.macuguita.branches.Branches.MOD_ID;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, RegistryKeys.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, RegistryKeys.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();


    public static final RegistrySupplier<Block> ACACIA_BRANCH = createBranch("acacia_branch", Blocks.ACACIA_LOG);
    public static final RegistrySupplier<Block> STRIPPED_ACACIA_BRANCH = createBranch("stripped_acacia_branch", Blocks.STRIPPED_ACACIA_WOOD);

    public static final RegistrySupplier<Block> BIRCH_BRANCH = createBranch("birch_branch", Blocks.BIRCH_LOG);
    public static final RegistrySupplier<Block> STRIPPED_BIRCH_BRANCH = createBranch("stripped_birch_branch", Blocks.STRIPPED_BIRCH_LOG);

    public static final RegistrySupplier<Block> CHERRY_BRANCH = createBranch("cherry_branch", Blocks.CHERRY_LOG);
    public static final RegistrySupplier<Block> STRIPPED_CHERRY_BRANCH = createBranch("stripped_cherry_branch", Blocks.STRIPPED_CHERRY_LOG);

    public static final RegistrySupplier<Block> DARK_OAK_BRANCH = createBranch("dark_oak_branch", Blocks.DARK_OAK_LOG);
    public static final RegistrySupplier<Block> STRIPPED_DARK_OAK_BRANCH = createBranch("stripped_dark_oak_branch", Blocks.STRIPPED_DARK_OAK_LOG);

    public static final RegistrySupplier<Block> JUNGLE_BRANCH = createBranch("jungle_branch", Blocks.JUNGLE_LOG);
    public static final RegistrySupplier<Block> STRIPPED_JUNGLE_BRANCH = createBranch("stripped_jungle_branch", Blocks.STRIPPED_JUNGLE_LOG);

    public static final RegistrySupplier<Block> MANGROVE_BRANCH = createBranch("mangrove_branch", Blocks.MANGROVE_LOG);
    public static final RegistrySupplier<Block> STRIPPED_MANGROVE_BRANCH = createBranch("stripped_mangrove_branch", Blocks.STRIPPED_MANGROVE_LOG);

    public static final RegistrySupplier<Block> OAK_BRANCH = createBranch("oak_branch", Blocks.OAK_LOG);
    public static final RegistrySupplier<Block> STRIPPED_OAK_BRANCH = createBranch("stripped_oak_branch", Blocks.STRIPPED_OAK_LOG);

    public static final RegistrySupplier<Block> SPRUCE_BRANCH = createBranch("spruce_branch", Blocks.SPRUCE_LOG);
    public static final RegistrySupplier<Block> STRIPPED_SPRUCE_BRANCH = createBranch("stripped_spruce_branch", Blocks.STRIPPED_SPRUCE_LOG);

    public static final RegistrySupplier<Block> CRIMSON_STIPE = createBranch("crimson_stipe", Blocks.CRIMSON_STEM);
    public static final RegistrySupplier<Block> STRIPPED_CRIMSON_STIPE = createBranch("stripped_crimson_stipe", Blocks.STRIPPED_CRIMSON_STEM);

    public static final RegistrySupplier<Block> WARPED_STIPE = createBranch("warped_stipe", Blocks.WARPED_STEM);
    public static final RegistrySupplier<Block> STRIPPED_WARPED_STIPE = createBranch("stripped_warped_stipe", Blocks.STRIPPED_WARPED_STEM);

    public static RegistrySupplier<Block> createBranch(String name, Block wood) {
        return registerWithItem(name, () -> new BranchBlock(AbstractBlock.Settings.copy(wood).mapColor(wood.getDefaultMapColor())));
    }

    public static void registerModBlocks() {
        Branches.LOGGER.info("Registering mod blocks for " + MOD_ID);
        ITEMS.register();
        BLOCKS.register();
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return RegUtils.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, new Identifier(MOD_ID, name), block);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return RegUtils.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, new Identifier(MOD_ID, path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return RegUtils.registerItem(ITEMS, ITEM_REGISTRAR, new Identifier(MOD_ID, path), itemSupplier);
    }
}
