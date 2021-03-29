package salyx.crystalline.divination.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import salyx.crystalline.divination.common.tiles.BaseRuneTile;
import salyx.crystalline.divination.core.init.TileEntityInit;

public class BaseRune extends Rune{
    public static int clickCooldown;

    public BaseRune(Properties properties) {
        super(properties);
        runCalculation(Block.makeCuboidShape(0, 0, 0, 16, 16, 1));
    }
    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        BaseRuneTile bte = (BaseRuneTile) worldIn.getTileEntity(pos);
        bte.crafted = false;
        clickCooldown = 0;
    }
    @SuppressWarnings({"deprecation"})
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote()) {
            //worldIn.getServer().getWorld(World.OVERWORLD).setDayTime(worldIn.getDayTime()+10);

            //TileEntity te = worldIn.getTileEntity(pos);
            BaseRuneTile bte = (BaseRuneTile) worldIn.getTileEntity(pos);
            LazyOptional<IItemHandler> itemHandler = bte.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            if(clickCooldown == 0) {
                if(player.isSneaking() && player.getHeldItemMainhand().isEmpty()) {
                    for(int e=4; e>-1; e--) {
                        int slot = e;
                        if(!bte.getItem(e).isEmpty()) {
                            itemHandler.ifPresent(h -> player.addItemStackToInventory(h.extractItem(slot, 1, false)));
                            break;
                        
                        }   
                    }
                }
                else if(!player.isSneaking() && !player.getHeldItemMainhand().isEmpty()){
                    for(int e=0; e<5; e++) {
                        int slot = e;
                        if(bte.getItem(e).isEmpty()) {
                            itemHandler.ifPresent(h -> h.insertItem(slot, player.getHeldItemMainhand().getItem().getDefaultInstance(), false));
                            player.getHeldItemMainhand().setCount(player.getHeldItemMainhand().getCount()-1);
                            break;
                        
                        }   
                    }
                }
                clickCooldown += 10;
                bte.markDirty();   
            }
        }
        worldIn.notifyBlockUpdate(pos, this.getDefaultState(), state, 0);
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
    

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        
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
        return TileEntityInit.BASE_RUNE_TILE_TYPE.get().create();
    }
    @SuppressWarnings( "deprecation" )
    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        BaseRuneTile bte = (BaseRuneTile) worldIn.getTileEntity(pos);
        if(!state.isIn(newState.getBlock()) && !bte.crafted) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof BaseRuneTile) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (BaseRuneTile)tileEntity);
            }
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
}
