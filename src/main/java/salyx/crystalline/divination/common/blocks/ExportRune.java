package salyx.crystalline.divination.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import salyx.crystalline.divination.common.tiles.ExportRuneTile;
import salyx.crystalline.divination.core.init.TileEntityInit;

public class ExportRune extends Rune{

    public ExportRune(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        // TODO Auto-generated method stub
        return TileEntityInit.EXPORT_RUNE_TILE_TYPE.get().create();
    }
    @SuppressWarnings( "deprecation" )
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        // TODO Auto-generated method stub
        if(!state.isIn(newState.getBlock())) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof ExportRuneTile) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (ExportRuneTile)tileEntity);
            }
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
}
