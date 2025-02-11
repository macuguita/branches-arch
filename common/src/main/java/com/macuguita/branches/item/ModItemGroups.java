package com.macuguita.branches.item;

import com.macuguita.branches.Branches;
import com.macuguita.branches.ModConfig;
import com.macuguita.branches.block.ModBlocks;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ModItemGroups {
    public static final DeferredRegister<ItemGroup> CREATIVE_MODE_TABS = DeferredRegister.create(Branches.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> BRANCH_TAB = CREATIVE_MODE_TABS.register(Branches.MOD_ID, () -> ItemGroup.create(ItemGroup.Row.TOP, 1)
            .icon(() -> new ItemStack(ModBlocks.OAK_BRANCH.get()))
            .displayName(Text.translatable("item_group.branches"))
            .entries((parameters, out) -> {
                out.add(new ItemStack(ModBlocks.OAK_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_OAK_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.SPRUCE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_SPRUCE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.BIRCH_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_BIRCH_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.JUNGLE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_JUNGLE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.ACACIA_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_ACACIA_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.DARK_OAK_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_DARK_OAK_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.MANGROVE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_MANGROVE_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.CHERRY_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_CHERRY_BRANCH.get()));
                out.add(new ItemStack(ModBlocks.CRIMSON_STIPE.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_CRIMSON_STIPE.get()));
                out.add(new ItemStack(ModBlocks.WARPED_STIPE.get()));
                out.add(new ItemStack(ModBlocks.STRIPPED_WARPED_STIPE.get()));
            })
            .build());

    public static void registerModItemGroups() {
        Branches.LOGGER.info("Registering item groups for " + Branches.MOD_ID);
        if (!ModConfig.showInVanillaItemGroups) {
            CREATIVE_MODE_TABS.register();
        }
        if (ModConfig.showInVanillaItemGroups) {
            registerItemGroups();
        }
    }

    public static void registerItemGroups() {
        var buildingBlocksGroup = Registries.ITEM_GROUP.get(ItemGroups.BUILDING_BLOCKS);

        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.OAK_WOOD), new ItemStack(ModBlocks.OAK_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_OAK_WOOD), new ItemStack(ModBlocks.STRIPPED_OAK_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.SPRUCE_WOOD), new ItemStack(ModBlocks.SPRUCE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_SPRUCE_WOOD), new ItemStack(ModBlocks.STRIPPED_SPRUCE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.BIRCH_WOOD), new ItemStack(ModBlocks.BIRCH_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_BIRCH_WOOD), new ItemStack(ModBlocks.STRIPPED_BIRCH_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.JUNGLE_WOOD), new ItemStack(ModBlocks.JUNGLE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_JUNGLE_WOOD), new ItemStack(ModBlocks.STRIPPED_JUNGLE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.ACACIA_WOOD), new ItemStack(ModBlocks.ACACIA_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_ACACIA_WOOD), new ItemStack(ModBlocks.STRIPPED_ACACIA_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.DARK_OAK_WOOD), new ItemStack(ModBlocks.DARK_OAK_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_DARK_OAK_WOOD), new ItemStack(ModBlocks.STRIPPED_DARK_OAK_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.MANGROVE_WOOD), new ItemStack(ModBlocks.MANGROVE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_MANGROVE_WOOD), new ItemStack(ModBlocks.STRIPPED_MANGROVE_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.CHERRY_WOOD), new ItemStack(ModBlocks.CHERRY_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_CHERRY_WOOD), new ItemStack(ModBlocks.STRIPPED_CHERRY_BRANCH.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.CRIMSON_STEM), new ItemStack(ModBlocks.CRIMSON_STIPE.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_CRIMSON_STEM), new ItemStack(ModBlocks.STRIPPED_CRIMSON_STIPE.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.WARPED_STEM), new ItemStack(ModBlocks.WARPED_STIPE.get()));
        });
        CreativeTabRegistry.modifyBuiltin(buildingBlocksGroup, (featureSet, output, hasPermissions) -> {
            output.acceptAfter(new ItemStack(Items.STRIPPED_WARPED_STEM), new ItemStack(ModBlocks.STRIPPED_WARPED_STIPE.get()));
        });

    }
}