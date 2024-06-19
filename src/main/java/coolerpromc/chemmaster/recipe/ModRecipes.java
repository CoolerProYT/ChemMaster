package coolerpromc.chemmaster.recipe;

import coolerpromc.chemmaster.ChemMaster;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChemMaster.MODID);

    public static final RegistryObject<RecipeSerializer<FluidSeparatingRecipe>> FLUID_SEPARATING_SERIALIZER =
            SERIALIZERS.register("fluid_separating", () -> FluidSeparatingRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<OreProcessingStationRecipe>> ORE_PROCESSING_SERIALIZER =
            SERIALIZERS.register("ore_processing", () -> OreProcessingStationRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<AirCoolerRecipe>> AIR_COOLING_SERIALIZER =
            SERIALIZERS.register("air_cooling", () -> AirCoolerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }
}
