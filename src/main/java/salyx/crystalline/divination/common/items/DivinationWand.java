package salyx.crystalline.divination.common.items;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import salyx.crystalline.divination.common.blocks.StorageRune;
import salyx.crystalline.divination.common.tiles.BaseRuneTile;
import salyx.crystalline.divination.common.tiles.ExportRuneTile;
import salyx.crystalline.divination.common.tiles.StorageRuneTile;
import salyx.crystalline.divination.core.init.BlockInit;
import salyx.crystalline.divination.core.init.ItemInit;

public class DivinationWand extends Item{

    public DivinationWand(Properties properties) {
        super(properties.maxStackSize(1));
        //TODO Auto-generated constructor stub
    }
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        
        if(context.getPlayer().isSneaking() && context.getWorld().getTileEntity(context.getPos()) instanceof BaseRuneTile){
            BaseRuneTile bte = (BaseRuneTile) context.getWorld().getTileEntity(context.getPos());
            if(bte.getItem(0).isItemEqualIgnoreDurability(Items.CHEST.getDefaultInstance()) &&
                bte.getItem(1).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(2).isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(3).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(4).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL.get().getDefaultInstance())) {
                    bte.crafted = true;
                    context.getWorld().setBlockState(context.getPos(), BlockInit.STORAGE_RUNE.get().getDefaultState()
                    .with(StorageRune.FACING, context.getWorld().getBlockState(context.getPos()).get(StorageRune.FACING)));
                }
            
            if(bte.getItem(0).isItemEqualIgnoreDurability(Items.GLASS_PANE.getDefaultInstance()) &&
                bte.getItem(1).isItemEqualIgnoreDurability(ItemInit.SOLAR_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(2).isItemEqualIgnoreDurability(ItemInit.LUNAR_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(3).isItemEqualIgnoreDurability(ItemInit.PYRO_CRYSTAL.get().getDefaultInstance()) &&
                bte.getItem(4).isItemEqualIgnoreDurability(ItemInit.HYDRO_CRYSTAL.get().getDefaultInstance())) {
                    bte.crafted = true;
                    context.getWorld().setBlockState(context.getPos(), Blocks.AIR.getDefaultState());
                    context.getPlayer().dropItem(ItemInit.CRYSTALLINE_TABLET.get().getDefaultInstance(), false, true);
                }
        }
        else if(context.getPlayer().isSneaking() && context.getWorld().getTileEntity(context.getPos()) instanceof StorageRuneTile){
            CompoundNBT nbt;
            if(context.getPlayer().getHeldItemMainhand().hasTag()) {
                nbt = context.getPlayer().getHeldItemMainhand().getTag();
            }
            else {
                nbt = new CompoundNBT();
            }
            nbt.putInt("X", context.getPos().getX());
            nbt.putInt("Y", context.getPos().getY());
            nbt.putInt("Z", context.getPos().getZ());
            context.getPlayer().getHeldItemMainhand().setTag(nbt);
        }
        else if(context.getPlayer().isSneaking() && context.getWorld().getTileEntity(context.getPos()) instanceof ExportRuneTile){
            CompoundNBT nbt;
            ExportRuneTile te = (ExportRuneTile) context.getWorld().getTileEntity(context.getPos());
            if(context.getPlayer().getHeldItemMainhand().hasTag()) {
                nbt = context.getPlayer().getHeldItemMainhand().getTag();
            }
            else {
                nbt = new CompoundNBT();
            }
            if(nbt.contains("X") && nbt.contains("Y") && nbt.contains("Z")){
                BlockPos sourcePos = new BlockPos(nbt.getInt("X"), nbt.getInt("Y"), nbt.getInt("Z"));
                if(sourcePos.withinDistance(te.getPos(), 64)) {
                    te.setSourceX(nbt.getInt("X"));
                    te.setSourceY(nbt.getInt("Y"));
                    te.setSourceZ(nbt.getInt("Z"));
                    te.setHasSource(true);
                }
            }
        }
        else if(context.getPlayer().isSneaking()){
            CompoundNBT nbt;
            if(context.getPlayer().getHeldItemMainhand().hasTag()) {
                nbt = context.getPlayer().getHeldItemMainhand().getTag();
            }
            else {
                nbt = new CompoundNBT();
            }
            if(nbt.contains("X")) {nbt.remove("X");}
            if(nbt.contains("Y")) {nbt.remove("Y");}
            if(nbt.contains("Z")) {nbt.remove("Z");}
        }

        return super.onItemUse(context);
    }
}
