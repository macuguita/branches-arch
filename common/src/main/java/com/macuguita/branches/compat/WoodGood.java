package com.macuguita.branches.compat;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.custom.BranchBlock;
import com.macuguita.branches.item.ModItemGroups;
import com.macuguita.branches.utils.ModTags;
import dev.architectury.registry.fuel.FuelRegistry;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.every_compat.dynamicpack.ClientDynamicResourcesHandler;
import net.mehvahdjukaar.every_compat.misc.SpriteHelper;
import net.mehvahdjukaar.moonlight.api.resources.BlockTypeResTransformer;
import net.mehvahdjukaar.moonlight.api.resources.RPUtils;
import net.mehvahdjukaar.moonlight.api.resources.textures.ImageTransformer;
import net.mehvahdjukaar.moonlight.api.resources.textures.TextureImage;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodTypeRegistry;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.ResourceManager;
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

    @Override
    public void addDynamicClientResources(ClientDynamicResourcesHandler handler, ResourceManager manager) {
        super.addDynamicClientResources(handler, manager);
        try {
            branchBlock.blocks.forEach((w, block) -> {
                Identifier id = Utils.getID(block);

                try (TextureImage branchTopTexture = TextureImage.open(manager,
                        RPUtils.findFirstBlockTextureLocation(manager, block, SpriteHelper.LOOKS_LIKE_TOP_LOG_TEXTURE));
                     TextureImage topTexture = TextureImage.open(manager,
                             RPUtils.findFirstBlockTextureLocation(manager, w.log, SpriteHelper.LOOKS_LIKE_TOP_LOG_TEXTURE))) {

                    String newId = BlockTypeResTransformer.replaceTypeNoNamespace("block/oak_branch_top", w, id, "oak");
                    var newTexture = branchTopTexture.makeCopy();

                    handler.addTextureIfNotPresent(manager, newId, () -> newTexture);

                    var newTop = branchTopTexture.makeCopy();
                    generateBranchTexture(topTexture, newTop);

                    handler.addTextureIfNotPresent(manager, newId, () -> newTop);

                } catch (Exception e) {
                    handler.getLogger().error("Failed to generate Branch block texture for for {} : {}", block, e);
                }
            });
        } catch (Exception e) {
            Branches.LOGGER.error("Failed to open branch_top texture: ", e);
        }
    }

    private void generateBranchTexture(TextureImage original, TextureImage target) {
        ImageTransformer transformer = ImageTransformer.builder(16, 16, 16, 16)
                // Apply the bark borders
                .copyRect(0, 0, 16, 1, 0, 4, 8, 1) // Top border
                .copyRect(0, 15, 16, 1, 0, 11, 8, 1) // Bottom border
                .copyRect(0, 0, 1, 16, 4, 0, 1, 8) // Left border
                .copyRect(15, 0, 1, 16, 11, 0, 1, 8) // Right border
                .build();

        transformer.apply(original, target);
    }

    public void strippedMapper(Block branch, Block strippedBranch) {
        BranchBlock.STRIPPED_BRANCHES.put(branch, strippedBranch);
    }
}
