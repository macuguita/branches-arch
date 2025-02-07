package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        createBranchRecipe(ModBlocks.ACACIA_BRANCH.get(), Blocks.ACACIA_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.BIRCH_BRANCH.get(), Blocks.BIRCH_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.CHERRY_BRANCH.get(), Blocks.CHERRY_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.DARK_OAK_BRANCH.get(), Blocks.DARK_OAK_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.JUNGLE_BRANCH.get(), Blocks.JUNGLE_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.MANGROVE_BRANCH.get(), Blocks.MANGROVE_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.OAK_BRANCH.get(), Blocks.OAK_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.SPRUCE_BRANCH.get(), Blocks.SPRUCE_LOG, recipeExporter);
        createBranchRecipe(ModBlocks.CRIMSON_STIPE.get(), Blocks.CRIMSON_STEM, recipeExporter);
        createBranchRecipe(ModBlocks.WARPED_STIPE.get(), Blocks.WARPED_STEM, recipeExporter);
    }

    private void createBranchRecipe(Block branch, Block log, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, branch, 16)
                .pattern("#")
                .pattern("#")
                .input('#', log)
                .criterion(RecipeProvider.hasItem(log), RecipeProvider.conditionsFromItem(log))
                .offerTo(exporter);

        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        Block strippedLog = ModUtils.getStrippedLogBlock(log);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, strippedBranch, 16)
                .pattern("#")
                .pattern("#")
                .input('#', strippedLog)
                .criterion(RecipeProvider.hasItem(strippedLog), RecipeProvider.conditionsFromItem(strippedLog))
                .offerTo(exporter);
    }
}