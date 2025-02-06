package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        createBranchRecipe(ModBlocks.ACACIA_BRANCH.get(), Blocks.ACACIA_LOG, consumer);
        createBranchRecipe(ModBlocks.BIRCH_BRANCH.get(), Blocks.BIRCH_LOG, consumer);
        createBranchRecipe(ModBlocks.CHERRY_BRANCH.get(), Blocks.CHERRY_LOG, consumer);
        createBranchRecipe(ModBlocks.DARK_OAK_BRANCH.get(), Blocks.DARK_OAK_LOG, consumer);
        createBranchRecipe(ModBlocks.JUNGLE_BRANCH.get(), Blocks.JUNGLE_LOG, consumer);
        createBranchRecipe(ModBlocks.MANGROVE_BRANCH.get(), Blocks.MANGROVE_LOG, consumer);
        createBranchRecipe(ModBlocks.OAK_BRANCH.get(), Blocks.OAK_LOG, consumer);
        createBranchRecipe(ModBlocks.SPRUCE_BRANCH.get(), Blocks.SPRUCE_LOG, consumer);
        createBranchRecipe(ModBlocks.CRIMSON_STIPE.get(), Blocks.CRIMSON_STEM, consumer);
        createBranchRecipe(ModBlocks.WARPED_STIPE.get(), Blocks.WARPED_STEM, consumer);
    }

    private void createBranchRecipe(Block branch, Block log, Consumer<RecipeJsonProvider> consumer) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, branch, 16)
                .pattern("#")
                .pattern("#")
                .input('#', log)
                .criterion(RecipeProvider.hasItem(log), RecipeProvider.conditionsFromItem(log))
                .offerTo(consumer);

        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        Block strippedLog = ModUtils.getStrippedLogBlock(log);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, strippedBranch, 16)
                .pattern("#")
                .pattern("#")
                .input('#', strippedLog)
                .criterion(RecipeProvider.hasItem(strippedLog), RecipeProvider.conditionsFromItem(strippedLog))
                .offerTo(consumer);
    }
}
