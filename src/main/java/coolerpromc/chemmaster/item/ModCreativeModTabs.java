package coolerpromc.chemmaster.item;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChemMaster.MODID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MOD_TABS.register("chemmaster",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEST_TUBE.get()))
                    .title(Component.translatable("creativetab.chemmaster"))
                    .displayItems((pParameters,pOutput) -> {
                        pOutput.accept(ModBlocks.FLUID_SEPARATOR.get());
                        pOutput.accept(ModBlocks.ORE_PROCESSING_STATION.get());
                        //Ore
                        pOutput.accept(ModBlocks.APATITE_ORE.get());
                        pOutput.accept(ModBlocks.ARGENTITE_ORE.get());
                        pOutput.accept(ModBlocks.ARSENOPYRITE_ORE.get());
                        pOutput.accept(ModBlocks.BARITE_ORE.get());
                        pOutput.accept(ModBlocks.BAUXITE_ORE.get());
                        pOutput.accept(ModBlocks.BERYL_ORE.get());
                        pOutput.accept(ModBlocks.BORAX_ORE.get());
                        pOutput.accept(ModBlocks.CASSITERITE_ORE.get());
                        pOutput.accept(ModBlocks.CELESTINE_ORE.get());
                        pOutput.accept(ModBlocks.CHROMITE_ORE.get());
                        pOutput.accept(ModBlocks.CINNABAR_ORE.get());
                        pOutput.accept(ModBlocks.COBALTITE_ORE.get());
                        pOutput.accept(ModBlocks.COLUMBITE_ORE.get());
                        pOutput.accept(ModBlocks.DOLOMITE_ORE.get());
                        pOutput.accept(ModBlocks.FLUORITE_ORE.get());
                        pOutput.accept(ModBlocks.GALENA_ORE.get());
                        pOutput.accept(ModBlocks.HALITE_ORE.get());
                        pOutput.accept(ModBlocks.LEPIDOLITE_ORE.get());
                        pOutput.accept(ModBlocks.LIMESTONE_ORE.get());
                        pOutput.accept(ModBlocks.MOLYBDENITE_ORE.get());
                        pOutput.accept(ModBlocks.MONAZITE_ORE.get());
                        pOutput.accept(ModBlocks.POTASH_ORE.get());
                        pOutput.accept(ModBlocks.PYROLUSITE_ORE.get());
                        pOutput.accept(ModBlocks.PENTLANDITE_ORE.get());
                        pOutput.accept(ModBlocks.POLLUCITE_ORE.get());
                        pOutput.accept(ModBlocks.RUTILE_ORE.get());
                        pOutput.accept(ModBlocks.SCHEELITE_ORE.get());
                        pOutput.accept(ModBlocks.SILICA_ORE.get());
                        pOutput.accept(ModBlocks.SPHALERITE_ORE.get());
                        pOutput.accept(ModBlocks.SPODUMENE_ORE.get());
                        pOutput.accept(ModBlocks.STIBNITE_ORE.get());
                        pOutput.accept(ModBlocks.SULFUR_ORE.get());
                        pOutput.accept(ModBlocks.TANTALITE_ORE.get());
                        pOutput.accept(ModBlocks.THORTVEITITE_ORE.get());
                        pOutput.accept(ModBlocks.URANINITE_ORE.get());
                        pOutput.accept(ModBlocks.VANADINITE_ORE.get());
                        pOutput.accept(ModBlocks.ZIRCON_ORE.get());

                        /*pOutput.accept(ModBlocks.ALUMINUM_ORE.get());
                        pOutput.accept(ModBlocks.LEAD_ORE.get());*/

                        //Raw
                        /*pOutput.accept(ModItems.RAW_LEAD.get());*/
                        pOutput.accept(ModItems.RAW_ALUMINUM.get());
                        pOutput.accept(ModItems.RAW_BERYLLIUM.get());
                        pOutput.accept(ModItems.RAW_LITHIUM.get());
                        pOutput.accept(ModItems.RAW_SILICON.get());

                        //Dust
                        /*pOutput.accept(ModItems.ALUMINUM_DUST.get());
                        pOutput.accept(ModItems.IRON_DUST.get());
                        pOutput.accept(ModItems.COPPER_DUST.get());
                        pOutput.accept(ModItems.LEAD_DUST.get());*/

                        //Ingot
                        /*pOutput.accept(ModItems.ALUMINUM_INGOT.get());
                        pOutput.accept(ModItems.LEAD_INGOT.get());*/

                        //Raw Block
                        /*pOutput.accept(ModBlocks.RAW_ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_LEAD_BLOCK.get());*/

                        //Block
                        /*pOutput.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.LEAD_BLOCK.get());*/

                        //Tube
                        pOutput.accept(ModItems.TEST_TUBE.get());
                        pOutput.accept(ModItems.WATER_TUBE.get());
                        /*pOutput.accept(ModItems.LIQUID_ALUMINUM.get());
                        pOutput.accept(ModItems.LIQUID_IRON.get());
                        pOutput.accept(ModItems.LIQUID_COPPER.get());
                        pOutput.accept(ModItems.LIQUID_LEAD.get());*/
                        pOutput.accept(ModItems.LIQUID_HYDROGEN.get());
                        pOutput.accept(ModItems.LIQUID_OXYGEN.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
