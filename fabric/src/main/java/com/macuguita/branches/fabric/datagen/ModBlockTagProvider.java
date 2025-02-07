package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModTags;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
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
        getOrCreateTagBuilder(ModTags.Blocks.BRANCHES)
                .add(branch)
                .add(strippedBranch);
        if (branch == ModBlocks.CRIMSON_STIPE || branch == ModBlocks.WARPED_STIPE) {
            getOrCreateTagBuilder(BlockTags.LOGS)
                    .add(branch)
                    .add(strippedBranch);
        } else {
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                    .add(branch)
                    .add(strippedBranch);
        }
    }
}
