package salyx.crystalline.divination.common.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import salyx.crystalline.divination.common.tiles.PedestalTile;
import salyx.crystalline.divination.core.init.TileEntityInit;

public class Pedestal extends BaseHorizontalBlock{

    public Pedestal(Properties properties) {
        super(properties);
        //TODO Auto-generated constructor stub
        runCalculation(Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
            Block.makeCuboidShape(4, 12, 4, 12, 13, 12),
            Block.makeCuboidShape(4, 1, 4, 12, 5, 12),
            Block.makeCuboidShape(5, 5, 5, 11, 9, 11),
            Block.makeCuboidShape(6, 9, 6, 10, 11, 10),
            Block.makeCuboidShape(5, 11, 5, 11, 12, 11)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get());
    }
    
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        // TODO Auto-generated method stub
        return Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
            Block.makeCuboidShape(4, 12, 4, 12, 13, 12),
            Block.makeCuboidShape(4, 1, 4, 12, 5, 12),
            Block.makeCuboidShape(5, 5, 5, 11, 9, 11),
            Block.makeCuboidShape(6, 9, 6, 10, 11, 10),
            Block.makeCuboidShape(5, 11, 5, 11, 12, 11)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    }


    // Tile Entity stuff
    @Override
    public boolean hasTileEntity(BlockState state) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        // TODO Auto-generated method stub
        return TileEntityInit.PEDESTAL_TILE_TYPE.get().create();
    }
    @SuppressWarnings( "deprecation" )
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            PedestalTile te = (PedestalTile) worldIn.getTileEntity(pos);
            LazyOptional<IItemHandler> itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            //if(te instanceof PedestalTile) {
            //    NetworkHooks.openGui((ServerPlayerEntity) player, (PedestalTile) te, pos);
            //}
            if(!player.getHeldItemMainhand().isEmpty() && te.getItem().isEmpty() && !player.isSneaking()){
                itemHandler.ifPresent(h -> h.insertItem(0, player.getHeldItemMainhand().getItem().getDefaultInstance(), false));
                player.getHeldItemMainhand().setCount(player.getHeldItemMainhand().getCount()-1);
            }
            else if(player.getHeldItemMainhand().isEmpty() && !te.getItem().isEmpty() && player.isSneaking()){
                //player.addItemStackToInventory
                itemHandler.ifPresent(h -> player.addItemStackToInventory(h.extractItem(0, 1, false)));
            }

        }


        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }


    @SuppressWarnings( "deprecation" )
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        // TODO Auto-generated method stub
        if(!state.isIn(newState.getBlock())) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof PedestalTile) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (PedestalTile)tileEntity);
            }
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
}
