package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModTags;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        addBranchTag(ModBlocks.ACACIA_BRANCH.get());
        addBranchTag(ModBlocks.BIRCH_BRANCH.get());
        addBranchTag(ModBlocks.CHERRY_BRANCH.get());
        addBranchTag(ModBlocks.DARK_OAK_BRANCH.get());
        addBranchTag(ModBlocks.JUNGLE_BRANCH.get());
        addBranchTag(ModBlocks.MANGROVE_BRANCH.get());
        addBranchTag(ModBlocks.OAK_BRANCH.get());
        addBranchTag(ModBlocks.SPRUCE_BRANCH.get());
        addBranchTag(ModBlocks.CRIMSON_STIPE.get());
        addBranchTag(ModBlocks.WARPED_STIPE.get());
    }

    private void addBranchTag(Block branch) {
        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        getOrCreateTagBuilder(ModTags.Items.BRANCHES)
                .add(branch.asItem())
                .add(strippedBranch.asItem());
        if (branch == ModBlocks.CRIMSON_STIPE || branch == ModBlocks.WARPED_STIPE) {
            getOrCreateTagBuilder(ItemTags.LOGS)
                    .add(branch.asItem())
                    .add(strippedBranch.asItem());
        } else {
            getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                    .add(branch.asItem())
                    .add(strippedBranch.asItem());
        }
    }
}
