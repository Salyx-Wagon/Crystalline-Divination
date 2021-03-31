package salyx.crystalline.divination.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import salyx.crystalline.divination.core.init.BlockInit;
import salyx.crystalline.divination.core.init.ItemInit;

public class LunarCrystalSeed extends CropsBlock{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D), Block.makeCuboidShape(2.0D, 0.0D, 3.0D, 13.0D, 13.0D, 14.0D), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)};

    public LunarCrystalSeed(Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
     }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }
    public IntegerProperty getAgeProperty() {
        return AGE;
    }
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return state.isIn(Blocks.BEDROCK) || state.isIn(Blocks.OBSIDIAN) || state.isIn(Blocks.NETHERITE_BLOCK);
    }
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        // TODO Auto-generated method stub
        return (worldIn.getLightSubtracted(pos, 0) <= 7 && this.isValidGround(worldIn.getBlockState(pos.down()), worldIn, pos.down()));
    }
    @Override
    protected IItemProvider getSeedsItem() {
        // TODO Auto-generated method stub
        return ItemInit.LUNAR_CRYSTAL.get();
    }
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public int getMaxAge() {
        // TODO Auto-generated method stub
        return 3;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightSubtracted(pos, 0) <= 7) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
            else {worldIn.setBlockState(pos, BlockInit.LUNAR_CRYSTAL_CLUSTER.get().getDefaultState());}
        }
    }
    protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
        float f = 1.0F;
        return f;
    }
    @Override
    public boolean ticksRandomly(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
}
