package coolerpromc.chemmaster.block.entity;

import coolerpromc.chemmaster.item.ModItems;
import coolerpromc.chemmaster.recipe.FluidSeparatingRecipe;
import coolerpromc.chemmaster.screen.FluidSeparatorMenu;
import coolerpromc.chemmaster.util.ModTag;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FluidSeparatorBlockEntity extends BlockEntity implements MenuProvider{
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private final ItemStackHandler itemHandler = new ItemStackHandler(3){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return slot == INPUT_SLOT;
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;


    public FluidSeparatorBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FLUID_SEPARATOR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> FluidSeparatorBlockEntity.this.progress;
                    case 1, 2 -> FluidSeparatorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> FluidSeparatorBlockEntity.this.progress = pValue;
                    case 1, 2 -> FluidSeparatorBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.chemmaster.fluid_separator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new FluidSeparatorMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("fluid_separator.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("fluid_separator.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        ItemStack inputStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
        if (inputStack.getCount() < 2) {
            resetProgress();
            return;
        }
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<FluidSeparatingRecipe> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            List<ItemStack> results = recipe.get().getOutputs();
            ItemStack inputStack = this.itemHandler.getStackInSlot(INPUT_SLOT);
            if (inputStack.getCount() < 2) {
                // If there are not enough items, do not proceed with crafting
                return;
            }

            // Extract the input item from the input slot
            this.itemHandler.extractItem(INPUT_SLOT, 2, false);

            // Loop through each result item and find suitable output slots
            for (ItemStack result : results) {
                int outputSlot = findSuitableOutputSlot(result);
                if (outputSlot != -1) {
                    this.itemHandler.setStackInSlot(outputSlot, new ItemStack(result.getItem(),
                            this.itemHandler.getStackInSlot(outputSlot).getCount() + result.getCount()));
                } else {
                    // Handle the case where no suitable output slot is found
                    // This can be logging an error, throwing an exception, or any other handling logic
                    System.err.println("No suitable output slot found for item: " + result);
                }
            }
        }
    }

    private int findSuitableOutputSlot(ItemStack result) {
        // Implement logic to find a suitable output slot for the given result
        // Return the slot index or -1 if no suitable slot is found
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            // Ensure we do not place the output item in the input slot
            if (i == INPUT_SLOT) {
                continue;
            }

            ItemStack stackInSlot = this.itemHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || (stackInSlot.getItem() == result.getItem() && stackInSlot.getCount() + result.getCount() <= stackInSlot.getMaxStackSize())) {
                return i;
            }
        }
        return -1;
    }



    private boolean hasRecipe() {
        Optional<FluidSeparatingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }

        List<ItemStack> results = recipe.get().getOutputs();

        for (ItemStack result : results) {
            if (!canInsertAmountIntoOutputSlot(result.getCount()) || !canInsertItemIntoOutputSlot(result.getItem())) {
                return false;
            }
        }

        return true;
    }


    private Optional<FluidSeparatingRecipe> getCurrentRecipe(){
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(FluidSeparatingRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        // Implement logic to check if the output slot can accept the given count of items
        // This logic should iterate over all output slots and ensure there's enough space for all output items
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            // Ensure we do not place the output item in the input slot
            if (i == INPUT_SLOT) {
                continue;
            }

            ItemStack stackInSlot = this.itemHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || stackInSlot.getCount() + count <= stackInSlot.getMaxStackSize()) {
                return true;
            }
        }
        return false;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        // Implement logic to check if the output slot can accept the given item
        // This logic should iterate over all output slots and ensure the item can be inserted
        for (int i = 0; i < this.itemHandler.getSlots(); i++) {
            // Ensure we do not place the output item in the input slot
            if (i == INPUT_SLOT) {
                continue;
            }

            ItemStack stackInSlot = this.itemHandler.getStackInSlot(i);
            if (stackInSlot.isEmpty() || stackInSlot.getItem() == item) {
                return true;
            }
        }
        return false;
    }


    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }
}
