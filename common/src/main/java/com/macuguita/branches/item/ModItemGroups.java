package com.macuguita.branches.item;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.ModBlocks;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import static com.macuguita.branches.Branches.MOD_ID;

public class ModItemGroups {
    public static final DeferredRegister<ItemGroup> TABS =
            DeferredRegister.create(Branches.MOD_ID, RegistryKeys.ITEM_GROUP);

    public static final RegistrySupplier<ItemGroup> BRANCHES_TAB = TABS.register(
            "branches_tab", // Tab ID
            () -> CreativeTabRegistry.create(
                    Text.translatable("category.architectury_test"), // Tab Name
                    () -> new ItemStack(ModBlocks.OAK_BRANCH.get().asItem()) // Icon
            )
    );
    public static void registerModItemGroups() {
        Branches.LOGGER.info("Registering mod item groups for " + MOD_ID);
    }
}
