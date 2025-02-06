package com.macuguita.branches.block.custom;

import com.macuguita.branches.utils.ModTags;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.ItemTags;

import java.util.Map;

public class BranchBlock extends ConnectingBlock implements Waterloggable {

    public static final Map<Block, Block> STRIPPED_BRANCHES = new Object2ObjectOpenHashMap<>();
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public BranchBlock(AbstractBlock.Settings settings) {
        super(0.25F, settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(NORTH, false)
                .with(EAST, false)
                .with(SOUTH, false)
                .with(WEST, false)
                .with(UP, false)
                .with(DOWN, false)
                .with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        FluidState fluidState = world.getFluidState(pos);
        Direction side = ctx.getSide();

        BlockState state = this.getDefaultState()
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);

        state = state
                .with(FACING_PROPERTIES.get(side), ctx.shouldCancelInteraction())
                .with(FACING_PROPERTIES.get(side.getOpposite()), true);

        return connectState(state, pos, world);
    }

    private BlockState connectState(BlockState state, BlockPos pos, WorldAccess world) {
        BlockState blockState = state;
        for (Direction direction : Direction.values()) {
            blockState = connectState(blockState, pos, world, direction);
        }
        return blockState;
    }

    private BlockState connectState(BlockState state, BlockPos pos, WorldAccess world, Direction direction) {
        BlockPos neighborPos = pos.offset(direction);
        BlockState neighborState = world.getBlockState(neighborPos);

        if (!neighborState.isIn(ModTags.Blocks.BRANCHES)) {
            return state;
        }

        BooleanProperty oppositeProperty = FACING_PROPERTIES.get(direction.getOpposite());
        if (neighborState.contains(oppositeProperty) && neighborState.get(oppositeProperty)) {
            return state.with(FACING_PROPERTIES.get(direction), true);
        } else {
            return state;
        }
    }

    @Deprecated
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        // Update connections based on the neighbor
        return connectState(super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos), pos, world, direction);
    }

    @Deprecated
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getItem() == Items.SHEARS) {
            boolean success = false;
            Vec3d hitPos = hit.getPos().subtract(pos.getX(), pos.getY(), pos.getZ());
            Direction direction = null;

            if (hitPos.x < 0.25) direction = Direction.WEST;
            else if (hitPos.x > 0.75) direction = Direction.EAST;
            else if (hitPos.y < 0.25) direction = Direction.DOWN;
            else if (hitPos.y > 0.75) direction = Direction.UP;
            else if (hitPos.z < 0.25) direction = Direction.NORTH;
            else if (hitPos.z > 0.75) direction = Direction.SOUTH;

            if (direction != null) {
                BooleanProperty property = FACING_PROPERTIES.get(direction);
                if (state.get(property)) {
                    world.setBlockState(pos, state.with(property, false), Block.NOTIFY_ALL);

                    BlockPos neighborPos = pos.offset(direction);
                    BlockState neighborState = world.getBlockState(neighborPos);
                    BooleanProperty oppositeProperty = FACING_PROPERTIES.get(direction.getOpposite());

                    if (neighborState.isIn(ModTags.Blocks.BRANCHES) && neighborState.get(oppositeProperty)) {
                        world.setBlockState(neighborPos, neighborState.with(oppositeProperty, false), Block.NOTIFY_ALL);
                    }
                    success = true;
                }
            }

            Direction side = hit.getSide();
            BooleanProperty property = FACING_PROPERTIES.get(side);
            if (!success && !state.get(property)) {
                world.setBlockState(pos, state.with(property, true), Block.NOTIFY_ALL);
                success = true;
            }

            if (success) {
                world.playSound(player, pos, SoundEvents.BLOCK_PUMPKIN_CARVE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!player.getAbilities().creativeMode) {
                    stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                }
                return ActionResult.success(world.isClient);
            }
        } else if (stack.isIn(ItemTags.AXES)) {
            Block strippedBlock = STRIPPED_BRANCHES.get(this);
            if (strippedBlock != null) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!world.isClient()) {
                    BlockState strippedState = strippedBlock.getDefaultState()
                            .with(WATERLOGGED, state.get(WATERLOGGED))
                            .with(NORTH, state.get(NORTH))
                            .with(EAST, state.get(EAST))
                            .with(SOUTH, state.get(SOUTH))
                            .with(WEST, state.get(WEST))
                            .with(UP, state.get(UP))
                            .with(DOWN, state.get(DOWN));

                    world.setBlockState(pos, strippedState, Block.NOTIFY_ALL);

                    if (!player.getAbilities().creativeMode) {
                        stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                    }
                }
                return ActionResult.success(world.isClient);
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Deprecated
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, WATERLOGGED);
    }
}
