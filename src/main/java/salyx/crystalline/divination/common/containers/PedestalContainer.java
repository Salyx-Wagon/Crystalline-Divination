package salyx.crystalline.divination.common.containers;

import java.util.Objects;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import salyx.crystalline.divination.common.tiles.PedestalTile;
import salyx.crystalline.divination.core.init.BlockInit;
import salyx.crystalline.divination.core.init.ContainerTypeInit;

public class PedestalContainer extends Container{

    public final PedestalTile te;
    private final IWorldPosCallable canInteractWithCallable;

    public PedestalContainer(final int windowId, final PlayerInventory playerInv, final PedestalTile te) {
        super(ContainerTypeInit.PEDESTAL_CONTAINER_TYPE.get(), windowId);
        this.te = te;
        this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());

        // Tile Entity
        this.addSlot(new Slot((IInventory) te, 0, 80, 35));

        // Main Player Inventory
        for(int row = 0; row < 3; row ++) {
            for(int col = 0; col < 9; col ++) {
                this.addSlot(new Slot(playerInv, col+row*9+9, 8+col*18, 166-(4-row)*18-10));
            }
        }
        // Player Hotbar
        for(int col = 0; col < 9; col ++) {
            this.addSlot(new Slot(playerInv, col, 8+col*18, 142));
        }
    }

    public PedestalContainer(final int windowId, final PlayerInventory playerInv, final PacketBuffer data) {
        this(windowId, playerInv, getTileEntity(playerInv, data));
    }

    private static PedestalTile getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
        Objects.requireNonNull(playerInv, "Player Inventory cannot be null.");
        Objects.requireNonNull(data, "Packet Buffer cannot be null.");
        final TileEntity te = playerInv.player.world.getTileEntity(data.readBlockPos());
        if(te instanceof PedestalTile) {
            return (PedestalTile) te;
        }
        throw new IllegalStateException("Tile Entity is not correct");
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        // TODO Auto-generated method stub
        return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.PEDESTAL.get());
    }
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();
            if(index < PedestalTile.slots && !this.mergeItemStack(stack1, PedestalTile.slots, this.inventorySlots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if(!this.mergeItemStack(stack1, 0, PedestalTile.slots, false)) {
                return ItemStack.EMPTY;
            }
            if(stack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            }
            else {
                slot.onSlotChanged();
            }
        }
        return stack;
    }
}
