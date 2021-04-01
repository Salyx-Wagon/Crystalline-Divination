package salyx.crystalline.divination.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import salyx.crystalline.divination.common.tiles.StorageRuneTile;

public class CrystallineTablet extends Item{

    

    public CrystallineTablet(Properties properties) {
        super(properties.maxStackSize(1));
    }
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
    }
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        CompoundNBT nbt;
        if(context.getPlayer().getHeldItemMainhand().hasTag()) {
            nbt = context.getPlayer().getHeldItemMainhand().getTag();
        }
        else {
            nbt = new CompoundNBT();
        }
        if(context.getPlayer().isSneaking() && context.getWorld().getTileEntity(context.getPos()) instanceof StorageRuneTile){
            nbt.putInt("X", context.getPos().getX());
            nbt.putInt("Y", context.getPos().getY());
            nbt.putInt("Z", context.getPos().getZ());
            //context.getPlayer().getHeldItemOffhand().write(nbt);
            context.getPlayer().getHeldItemMainhand().setTag(nbt);
        }
        return super.onItemUse(context);
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!playerIn.isSneaking()){
            CompoundNBT nbt;
            if(playerIn.getHeldItemMainhand().hasTag()) {
                nbt = playerIn.getHeldItemMainhand().getTag();
            }
            else {
                nbt = new CompoundNBT();
            }
            BlockPos pos = new BlockPos(nbt.getInt("X"), (nbt.getInt("Y")), (nbt.getInt("Z")));
            if(nbt.contains("X") && nbt.contains("Y") && nbt.contains("Z")){
                //worldIn.getServer().getCommandManager().handleCommand(null, "forceload")
                TileEntity te = worldIn.getTileEntity(pos);
                if(te instanceof StorageRuneTile && !worldIn.isRemote){
                    NetworkHooks.openGui((ServerPlayerEntity) playerIn, (StorageRuneTile) te, te.getPos());
                    //System.out.println(ItemStack.read(nbt));
                }
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
