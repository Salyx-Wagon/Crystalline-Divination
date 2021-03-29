package salyx.crystalline.divination.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class HydroCrystalCluster extends BaseCrystalCluster{

    public HydroCrystalCluster(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState()
        .with(WATERLOGGED, true)
        .with(PICKLES, 4));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(2, 0, 2, 14, 16, 14);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
        // TODO Auto-generated method stub
        return 8;
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        // TODO Auto-generated method stub
        worldIn.spawnParticle(ParticleTypes.FALLING_WATER, 0.5 + pos.getX(), 0.5 + pos.getY(), 0.5 + pos.getZ(), 10, 0.3, 0.3, 0.3, 0.07);
    }
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        // TODO Auto-generated method stub
        return this.getDefaultState().with(WATERLOGGED, false);
    }
}

