package coolerpromc.chemmaster.screen;

import coolerpromc.chemmaster.ChemMaster;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChemMaster.MODID);

    public static final RegistryObject<MenuType<FluidSeparatorMenu>> FLUID_SEPARATOR_MENU =
            registerMenuType("fluid_separating_menu", FluidSeparatorMenu::new);
    public static final RegistryObject<MenuType<OreProcessingStationMenu>> ORE_PROCESSING_STATION_MENU =
            registerMenuType("ore_processing_station_menu", OreProcessingStationMenu::new);
    public static final RegistryObject<MenuType<AirCoolerMenu>> AIR_COOLER_MENU =
            registerMenuType("air_cooler_menu", AirCoolerMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
