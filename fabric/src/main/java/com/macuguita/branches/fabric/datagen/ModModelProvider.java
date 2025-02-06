package com.macuguita.branches.fabric.datagen;

import com.macuguita.branches.Branches;
import com.macuguita.branches.block.ModBlocks;
import com.macuguita.branches.utils.ModUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.data.client.*;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generateBranchModel(generator, ModBlocks.ACACIA_BRANCH.get(), Blocks.ACACIA_LOG);
        generateBranchModel(generator, ModBlocks.BIRCH_BRANCH.get(), Blocks.BIRCH_LOG);
        generateBranchModel(generator, ModBlocks.CHERRY_BRANCH.get(), Blocks.CHERRY_LOG);
        generateBranchModel(generator, ModBlocks.DARK_OAK_BRANCH.get(), Blocks.DARK_OAK_LOG);
        generateBranchModel(generator, ModBlocks.JUNGLE_BRANCH.get(), Blocks.JUNGLE_LOG);
        generateBranchModel(generator, ModBlocks.MANGROVE_BRANCH.get(), Blocks.MANGROVE_LOG);
        generateBranchModel(generator, ModBlocks.OAK_BRANCH.get(), Blocks.OAK_LOG);
        generateBranchModel(generator, ModBlocks.SPRUCE_BRANCH.get(), Blocks.SPRUCE_LOG);
        generateBranchModel(generator, ModBlocks.CRIMSON_STIPE.get(), Blocks.CRIMSON_STEM);
        generateBranchModel(generator, ModBlocks.WARPED_STIPE.get(), Blocks.WARPED_STEM);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        // Implement item model generation if needed
    }

    private void generateBranchModel(BlockStateModelGenerator generator, Block branch, Block log) {
        Block strippedBranch = ModUtils.getStrippedBranchBlock(branch);
        Block strippedLog = ModUtils.getStrippedLogBlock(log);
        registerBranch(generator, branch, log);
        registerBranch(generator, strippedBranch, strippedLog);
    }

    private static final Model BRANCH_FACE = new Model(
            Optional.of(Identifier.of(Branches.MOD_ID, "block/template_branch_face")),
            Optional.of("_face"),
            TextureKey.SIDE
    );

    private static final Model BRANCH_FACE_HORIZONTAL = new Model(
            Optional.of(Identifier.of(Branches.MOD_ID, "block/template_branch_face_horizontal")),
            Optional.of("_face_horizontal"),
            TextureKey.SIDE
    );

    private static final Model BRANCH_FRONT = new Model(
            Optional.of(Identifier.of(Branches.MOD_ID, "block/template_branch_front")),
            Optional.of("_front"),
            TextureKey.TOP, TextureKey.SIDE
    );

    private static final Model BRANCH_BACK = new Model(
            Optional.of(Identifier.of(Branches.MOD_ID, "block/template_branch_back")),
            Optional.of("_back"),
            TextureKey.TOP, TextureKey.SIDE
    );

    private static final Model BRANCH_INVENTORY = new Model(
            Optional.of(Identifier.of(Branches.MOD_ID, "block/template_branch_inventory")),
            Optional.of("_inventory"),
            TextureKey.TOP, TextureKey.SIDE
    );

    private void registerBranch(BlockStateModelGenerator generator, Block branch, Block log) {
        registerBranch(generator, branch, log, TextureMap.getSubId(branch, "_top"));
    }

    private void registerBranch(BlockStateModelGenerator generator, Block branch, Block log, Identifier topTexture) {
        TextureMap faceMap = new TextureMap().put(TextureKey.SIDE, TextureMap.getId(log));
        TextureMap map = faceMap.copyAndAdd(TextureKey.TOP, topTexture);
        Identifier face = BRANCH_FACE.upload(branch, faceMap, generator.modelCollector);
        Identifier faceHorizontal = BRANCH_FACE_HORIZONTAL.upload(branch, faceMap, generator.modelCollector);
        Identifier front = BRANCH_FRONT.upload(branch, map, generator.modelCollector);
        Identifier back = BRANCH_BACK.upload(branch, map, generator.modelCollector);
        Identifier inventory = BRANCH_INVENTORY.upload(branch, map, generator.modelCollector);
        generator.registerParentedItemModel(branch, inventory);
        MultipartBlockStateSupplier blockStateSupplier = MultipartBlockStateSupplier.create(branch);

        for (Direction side : Direction.values()) {
            addBranchSide(blockStateSupplier, side, face, faceHorizontal, front, back);
        }

        generator.blockStateCollector.accept(blockStateSupplier);
    }

    private BlockStateVariant rotateBranchSide(BlockStateVariant variant, Direction side) {
        switch (side.getAxis()) {
            case X:
                return variant.put(VariantSettings.Y, VariantSettings.Rotation.R90);
            case Y:
                return variant.put(VariantSettings.X, VariantSettings.Rotation.R270);
            case Z:
                return variant;
            default:
                throw new IncompatibleClassChangeError();
        }
    }

    private void addBranchSide(MultipartBlockStateSupplier blockStateSupplier, Direction side, Identifier face, Identifier faceHorizontal, Identifier front, Identifier back) {
        BooleanProperty sideProperty = ConnectingBlock.FACING_PROPERTIES.get(side);
        if (sideProperty == null) {
            throw new IllegalArgumentException("No BooleanProperty found for side: " + side);
        }

        BooleanProperty horizontalProperty1 = ConnectingBlock.FACING_PROPERTIES.get(side.getAxis().isVertical() ? Direction.EAST : side.rotateYClockwise());
        if (horizontalProperty1 == null) {
            throw new IllegalArgumentException("No BooleanProperty found for side: " + side);
        }

        BooleanProperty horizontalProperty2 = ConnectingBlock.FACING_PROPERTIES.get(side.getAxis().isVertical() ? Direction.WEST : side.rotateYCounterclockwise());
        if (horizontalProperty2 == null) {
            throw new IllegalArgumentException("No BooleanProperty found for side: " + side);
        }

        boolean isFront = side.getDirection() == (side.getAxis() == Direction.Axis.Z ? Direction.AxisDirection.NEGATIVE : Direction.AxisDirection.POSITIVE);

        blockStateSupplier.with(
                When.create().set(sideProperty, true),
                rotateBranchSide(BlockStateVariant.create().put(VariantSettings.MODEL, isFront ? front : back), side)
        ).with(
                When.create().set(sideProperty, false).set(horizontalProperty1, false).set(horizontalProperty2, false),
                rotateForFace(BlockStateVariant.create().put(VariantSettings.MODEL, face), side, false)
        ).with(
                When.create().set(sideProperty, false).set(horizontalProperty1, true).set(horizontalProperty2, false),
                rotateForFace(BlockStateVariant.create().put(VariantSettings.MODEL, face), side, false)
        ).with(
                When.create().set(sideProperty, false).set(horizontalProperty1, false).set(horizontalProperty2, true),
                rotateForFace(BlockStateVariant.create().put(VariantSettings.MODEL, face), side, false)
        ).with(
                When.create().set(sideProperty, false).set(horizontalProperty1, true).set(horizontalProperty2, true),
                rotateForFace(BlockStateVariant.create().put(VariantSettings.MODEL, faceHorizontal), side, false)
        );
    }

    protected BlockStateVariant rotateForFace(BlockStateVariant variant, Direction direction, boolean uvlock) {
        if (uvlock) {
            variant.put(VariantSettings.UVLOCK, true);
        }

        switch (direction) {
            case EAST:
                variant.put(VariantSettings.Y, VariantSettings.Rotation.R90);
                break;
            case SOUTH:
                variant.put(VariantSettings.Y, VariantSettings.Rotation.R180);
                break;
            case WEST:
                variant.put(VariantSettings.Y, VariantSettings.Rotation.R270);
                break;
            case UP:
                variant.put(VariantSettings.X, VariantSettings.Rotation.R270);
                break;
            case DOWN:
                variant.put(VariantSettings.X, VariantSettings.Rotation.R90);
                break;
            case NORTH:
                break;
        }

        return variant;
    }
}
