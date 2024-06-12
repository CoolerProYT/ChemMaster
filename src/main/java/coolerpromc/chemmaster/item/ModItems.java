package coolerpromc.chemmaster.item;

import coolerpromc.chemmaster.ChemMaster;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChemMaster.MODID);

    //Register Item
    public static final RegistryObject<Item> TEST_TUBE = ITEMS.register("test_tube",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_IRON = ITEMS.register("liquid_iron",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIQUID_ALUMINUM = ITEMS.register("liquid_aluminum",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_COPPER = ITEMS.register("liquid_copper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_DUST = ITEMS.register("lead_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIQUID_LEAD = ITEMS.register("liquid_lead",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LIQUID_HYDROGEN = ITEMS.register("liquid_hydrogen",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIQUID_OXYGEN = ITEMS.register("liquid_oxygen",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_TUBE = ITEMS.register("water_tube",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
