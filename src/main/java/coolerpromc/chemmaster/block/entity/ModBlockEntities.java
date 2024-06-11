package coolerpromc.chemmaster.block.entity;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChemMaster.MODID);

    public static final RegistryObject<BlockEntityType<FluidSeparatorBlockEntity>> FLUID_SEPARATOR_BE = BLOCK_ENTITIES.register("fluid_separator_be",
            () -> BlockEntityType.Builder.of(FluidSeparatorBlockEntity::new, ModBlocks.FLUID_SEPARATOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
