package coolerpromc.chemmaster.datagen;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChemMaster.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TEST_TUBE);

        simpleItem(ModItems.LIQUID_IRON);
        simpleItem(ModItems.IRON_DUST);

        simpleItem(ModItems.ALUMINUM_INGOT);
        simpleItem(ModItems.ALUMINUM_DUST);
        simpleItem(ModItems.LIQUID_ALUMINUM);
        simpleItem(ModItems.RAW_ALUMINUM);

        simpleItem(ModItems.LIQUID_COPPER);
        simpleItem(ModItems.COPPER_DUST);

        simpleItem(ModItems.LEAD_INGOT);
        simpleItem(ModItems.LEAD_DUST);
        simpleItem(ModItems.LIQUID_LEAD);
        simpleItem(ModItems.RAW_LEAD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChemMaster.MODID,"item/" + item.getId().getPath()));
    }
}
