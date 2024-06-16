package coolerpromc.chemmaster.handler;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class CustomItemHandler extends ItemStackHandler {
    public CustomItemHandler(int size) {
        super(size);
    }

    public ItemStack internalExtractItem(int slot, int amount, boolean simulate) {
        return super.extractItem(slot, amount, simulate);
    }
}

