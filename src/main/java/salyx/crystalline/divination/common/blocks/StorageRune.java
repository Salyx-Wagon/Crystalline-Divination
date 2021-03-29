package salyx.crystalline.divination.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import salyx.crystalline.divination.common.tiles.StorageRuneTile;
import salyx.crystalline.divination.core.init.TileEntityInit;

public class StorageRune extends Rune{
    public StorageRune(Properties properties) {
        super(properties);
        runCalculation(Block.makeCuboidShape(0, 0, 0, 16, 16, 1));
    }
    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
    }
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {

            TileEntity te = worldIn.getTileEntity(pos);
            StorageRuneTile ste = (StorageRuneTile) worldIn.getTileEntity(pos);
            LazyOptional<IItemHandler> itemHandler = ste.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            if(itemHandler.isPresent()) {} //temp

            if(te instanceof StorageRuneTile) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (StorageRuneTile) te, pos);
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        // TODO Auto-generated method stub
        return TileEntityInit.STORAGE_RUNE_TILE_TYPE.get().create();
    }
    @SuppressWarnings( "deprecation" )
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        // TODO Auto-generated method stub
        if(!state.isIn(newState.getBlock())) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof StorageRuneTile) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (StorageRuneTile)tileEntity);
            }
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
}
