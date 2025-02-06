package com.macuguita.branches.forge.item;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModItemGroups {

    public static final DeferredRegister<ItemGroup> CREATIVE_MODE_TABS =
            DeferredRegister.create((Identifier) Registries.ITEM_GROUP, Branches.MOD_ID);

    public static final RegistryObject<ItemGroup> BRANCHES_TAB = CREATIVE_MODE_TABS.register("branches_tab",
            () -> ItemGroup.builder().icon(() -> new ItemStack(ModBlocks.OAK_BRANCH.asItem()))
                    .displayName(Text.translatable("item_group.branches"))
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
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
