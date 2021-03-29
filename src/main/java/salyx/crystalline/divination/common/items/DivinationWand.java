package salyx.crystalline.divination.common.items;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import salyx.crystalline.divination.common.blocks.StorageRune;
import salyx.crystalline.divination.common.tiles.BaseRuneTile;
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
        return super.onItemUse(context);
    }
}
