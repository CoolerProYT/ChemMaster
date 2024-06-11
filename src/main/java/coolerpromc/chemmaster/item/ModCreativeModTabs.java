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
                        //Ore
                        pOutput.accept(ModBlocks.ALUMINUM_ORE.get());
                        pOutput.accept(ModBlocks.LEAD_ORE.get());

                        //Raw
                        pOutput.accept(ModItems.RAW_ALUMINUM.get());
                        pOutput.accept(ModItems.RAW_LEAD.get());

                        //Dust
                        pOutput.accept(ModItems.ALUMINUM_DUST.get());
                        pOutput.accept(ModItems.IRON_DUST.get());
                        pOutput.accept(ModItems.COPPER_DUST.get());
                        pOutput.accept(ModItems.LEAD_DUST.get());

                        //Ingot
                        pOutput.accept(ModItems.ALUMINUM_INGOT.get());
                        pOutput.accept(ModItems.LEAD_INGOT.get());

                        //Raw Block
                        pOutput.accept(ModBlocks.RAW_ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_LEAD_BLOCK.get());

                        //Block
                        pOutput.accept(ModBlocks.ALUMINUM_BLOCK.get());
                        pOutput.accept(ModBlocks.LEAD_BLOCK.get());

                        //Tube
                        pOutput.accept(ModItems.TEST_TUBE.get());
                        pOutput.accept(ModItems.LIQUID_ALUMINUM.get());
                        pOutput.accept(ModItems.LIQUID_IRON.get());
                        pOutput.accept(ModItems.LIQUID_COPPER.get());
                        pOutput.accept(ModItems.LIQUID_LEAD.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
