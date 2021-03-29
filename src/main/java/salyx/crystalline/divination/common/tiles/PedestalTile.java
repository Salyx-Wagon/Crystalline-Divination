package salyx.crystalline.divination.common.tiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import salyx.crystalline.divination.CrystalDiv;
import salyx.crystalline.divination.common.containers.PedestalContainer;
import salyx.crystalline.divination.core.init.TileEntityInit;

public class PedestalTile extends LockableLootTileEntity implements ITickableTileEntity{

    public static int slots = 1;

    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    protected PedestalTile(TileEntityType<?> typeIn) {
        super(typeIn);
    }
    public PedestalTile() {
        this(TileEntityInit.PEDESTAL_TILE_TYPE.get());
    }
    @Override
    public int getSizeInventory() {
        return slots;
    }
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    public ItemStack getItem() {
        return this.items.get(0);
    }
    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + CrystalDiv.MOD_ID + ".pedestal");
    }
    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new PedestalContainer(id, player, this);
    }
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if(!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items);
        }
        return compound;
    }
    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.items = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        if(!this.checkLootAndRead(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }
    @Override
    public void tick() {
        // TODO Auto-generated method stub
        this.world.notifyBlockUpdate(pos, this.getBlockState(), this.getBlockState(), 0);
    }
    @Override
    public CompoundNBT serializeNBT() {
        // TODO Auto-generated method stub
        return super.serializeNBT();
    }
    @Override
    public CompoundNBT getUpdateTag() {
        // TODO Auto-generated method stub
        return this.write(new CompoundNBT());
    }
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.write(nbt);
        return new SUpdateTileEntityPacket(this.getPos(), 0, nbt);
    }
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(this.getBlockState(), pkt.getNbtCompound());
    }
}
