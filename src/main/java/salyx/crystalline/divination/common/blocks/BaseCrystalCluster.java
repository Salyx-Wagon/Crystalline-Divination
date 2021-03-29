package salyx.crystalline.divination.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BaseCrystalCluster extends SeaPickleBlock{

    public BaseCrystalCluster(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState()
        .with(WATERLOGGED, false)
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
} 

