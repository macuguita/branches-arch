package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {


    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        generateBranchTranslations(ModBlocks.ACACIA_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.BIRCH_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.CHERRY_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.DARK_OAK_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.JUNGLE_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.MANGROVE_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.OAK_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.SPRUCE_BRANCH.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.CRIMSON_STIPE.get(), translationBuilder);
        generateBranchTranslations(ModBlocks.WARPED_STIPE.get(), translationBuilder);

        translationBuilder.add("block_type.branches.branch", "%s Branch");
        translationBuilder.add("block_type.branches.stripped_branch", "Stripped %s Branch");
        translationBuilder.add("item_group.branches", "Branches");
        translationBuilder.add("tag.item.branches.branches", "Branches");
        translationBuilder.add("branches.midnightconfig.title", "guita's Branches");
        translationBuilder.add("branches.midnightconfig.showInVanillaItemGroups", "Show in vanilla Creative Tabs");
    }

    private String capitalizeString(String string) {
        char[] chars = string.toLowerCase(Locale.getDefault()).toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false;
            }
        }
        return new String(chars);
    }

    private void generateBlockTranslations(Block block, TranslationBuilder translationBuilder) {
        String temp = capitalizeString(Registries.BLOCK.getId(block).getPath().replace("_", " "));
        translationBuilder.add(block, temp);
    }

    private void generateItemTranslations(Item item, TranslationBuilder translationBuilder) {
        String temp = capitalizeString(Registries.ITEM.getId(item).getPath().replace("_", " "));
        translationBuilder.add(item, temp);
    }

    private void generateBranchTranslations(Block branch, TranslationBuilder translationBuilder) {
        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        generateBlockTranslations(branch, translationBuilder);
        generateBlockTranslations(strippedBranch, translationBuilder);
    }
}