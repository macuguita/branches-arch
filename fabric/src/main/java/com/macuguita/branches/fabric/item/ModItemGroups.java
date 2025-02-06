package com.macuguita.branches.fabric.item;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BRANCH_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Branches.MOD_ID, "branch_item_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("item_group.branches"))
                    .icon(() -> new ItemStack(ModBlocks.OAK_BRANCH.asItem()))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.OAK_BRANCH.asItem());
                        entries.add(ModBlocks.SPRUCE_BRANCH.asItem());
                        entries.add(ModBlocks.BIRCH_BRANCH.asItem());
                        entries.add(ModBlocks.JUNGLE_BRANCH.asItem());
                        entries.add(ModBlocks.ACACIA_BRANCH.asItem());
                        entries.add(ModBlocks.DARK_OAK_BRANCH.asItem());
                        entries.add(ModBlocks.MANGROVE_BRANCH.asItem());
                        entries.add(ModBlocks.CHERRY_BRANCH.asItem());
                        entries.add(ModBlocks.CRIMSON_STIPE.asItem());
                        entries.add(ModBlocks.WARPED_STIPE.asItem());

                        // Stripped branches follow
                        entries.add(ModBlocks.STRIPPED_OAK_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_SPRUCE_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_BIRCH_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_JUNGLE_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_ACACIA_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_DARK_OAK_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_MANGROVE_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_CHERRY_BRANCH.asItem());
                        entries.add(ModBlocks.STRIPPED_CRIMSON_STIPE.asItem());
                        entries.add(ModBlocks.STRIPPED_WARPED_STIPE.asItem());
                    })
                    .build()
    );

    public static void registerItemGroups() {
        Branches.LOGGER.info("Registering item groups for " + Branches.MOD_ID);
    }
}
