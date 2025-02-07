package com.macuguita.branches.compat;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.custom.BranchBlock;
import com.macuguita.branches.item.ModItemGroups;
import com.macuguita.branches.utils.ModTags;
import dev.architectury.registry.fuel.FuelRegistry;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class WoodGood extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> branchBlock;
    public final SimpleEntrySet<WoodType, Block> strippedBranchBlock;

    public WoodGood(String modId, String shortId) {
        super(modId, shortId);
        var tab = ModItemGroups.BRANCH_TAB.getId();

        branchBlock = SimpleEntrySet.builder(WoodType.class, "branch",
                        getModBlock("oak_branch"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new BranchBlock(Utils.copyPropertySafe(w.log))
                )
                .addTag(ModTags.Blocks.BRANCHES, Registries.BLOCK.getKey())
                .addTag(ModTags.Items.BRANCHES, Registries.ITEM.getKey())
                .addTag(BlockTags.LOGS_THAT_BURN, Registries.BLOCK.getKey())
                .addTag(ItemTags.LOGS_THAT_BURN, Registries.ITEM.getKey())
                .setTabKey(tab)
                .addTexture(Identifier.of("minecraft", "block/oak_log"))  // Base texture
                .addTexture(Identifier.of(Branches.MOD_ID, "block/oak_branch_top"))  // Top texture
                .defaultRecipe()
                .build();
        this.addEntry(branchBlock);


        strippedBranchBlock = SimpleEntrySet.builder(WoodType.class, "branch", "stripped",
                        getModBlock("stripped_oak_branch"), () -> WoodTypeRegistry.OAK_TYPE,
                        w -> new BranchBlock(Utils.copyPropertySafe(w.log))
                )
                .requiresChildren("stripped_log")
                .addTag(ModTags.Blocks.BRANCHES, Registries.BLOCK.getKey())
                .addTag(ModTags.Items.BRANCHES, Registries.ITEM.getKey())
                .addTag(BlockTags.LOGS_THAT_BURN, Registries.BLOCK.getKey())
                .addTag(ItemTags.LOGS_THAT_BURN, Registries.ITEM.getKey())
                .setTabKey(tab)
                .addTexture(Identifier.of("minecraft", "block/stripped_oak_log"))  // Base texture
                .addTexture(Identifier.of(Branches.MOD_ID, "block/stripped_oak_branch_top"))  // Top texture
                .defaultRecipe()
                .build();
        this.addEntry(strippedBranchBlock);
    }
    @Override
    public void onModSetup() {
        branchBlock.blocks.forEach((w, block) -> {

            Block stripped = strippedBranchBlock.blocks.get(w);
            dev.architectury.registry.fuel.FuelRegistry.register(37, block);
            if (stripped != null) {
                strippedMapper(block, stripped);
                FuelRegistry.register(37, stripped);
            }
        });
    }

    public void strippedMapper(Block branch, Block strippedBranch) {
        BranchBlock.STRIPPED_BRANCHES.put(branch, strippedBranch);
    }
}
