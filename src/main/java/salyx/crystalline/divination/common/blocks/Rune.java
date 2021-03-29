package salyx.crystalline.divination.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Rune extends BaseRotationalBlock{

    public Rune(Properties properties) {
        super(properties);
        runCalculation(Block.makeCuboidShape(0, 0, 0, 16, 16, 1));
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(FACING));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos,
            ISelectionContext context) {
        // TODO Auto-generated method stub
        return Block.makeCuboidShape(0, 0, 0, 0, 0, 0);
    }
}
