package com.macuguita.branches.item;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.ModBlocks;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
        CREATIVE_MODE_TABS.register();
    }
}
