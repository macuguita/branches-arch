package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addBranchDrop(ModBlocks.ACACIA_BRANCH.get());
        addBranchDrop(ModBlocks.BIRCH_BRANCH.get());
        addBranchDrop(ModBlocks.CHERRY_BRANCH.get());
        addBranchDrop(ModBlocks.DARK_OAK_BRANCH.get());
        addBranchDrop(ModBlocks.JUNGLE_BRANCH.get());
        addBranchDrop(ModBlocks.MANGROVE_BRANCH.get());
        addBranchDrop(ModBlocks.OAK_BRANCH.get());
        addBranchDrop(ModBlocks.SPRUCE_BRANCH.get());
        addBranchDrop(ModBlocks.CRIMSON_STIPE.get());
        addBranchDrop(ModBlocks.WARPED_STIPE.get());
    }

    private void addBranchDrop(Block branch) {
        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        addDrop(branch);
        addDrop(strippedBranch);
    }
}
