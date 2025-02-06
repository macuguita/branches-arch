package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addBranchDrop(ModBlocks.ACACIA_BRANCH);
        addBranchDrop(ModBlocks.BIRCH_BRANCH);
        addBranchDrop(ModBlocks.CHERRY_BRANCH);
        addBranchDrop(ModBlocks.DARK_OAK_BRANCH);
        addBranchDrop(ModBlocks.JUNGLE_BRANCH);
        addBranchDrop(ModBlocks.MANGROVE_BRANCH);
        addBranchDrop(ModBlocks.OAK_BRANCH);
        addBranchDrop(ModBlocks.SPRUCE_BRANCH);
        addBranchDrop(ModBlocks.CRIMSON_STIPE);
        addBranchDrop(ModBlocks.WARPED_STIPE);
    }

    private void addBranchDrop(Block branch) {
        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        addDrop(branch);
        addDrop(strippedBranch);
    }
}
