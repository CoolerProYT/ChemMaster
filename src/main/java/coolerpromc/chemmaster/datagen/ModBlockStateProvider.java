package coolerpromc.chemmaster.datagen;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChemMaster.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.RAW_ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_ORE);

        blockWithItem(ModBlocks.LEAD_BLOCK);
        blockWithItem(ModBlocks.RAW_LEAD_BLOCK);
        blockWithItem(ModBlocks.LEAD_ORE);*/

        simpleBlock(ModBlocks.FLUID_SEPARATOR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/fluid_separator")));
        simpleBlock(ModBlocks.ORE_PROCESSING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/ore_processing_station")));
        simpleBlock(ModBlocks.AIR_COOLER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/air_cooler")));

        blockWithItem(ModBlocks.SPODUMENE_ORE);
        blockWithItem(ModBlocks.BERYL_ORE);
        blockWithItem(ModBlocks.BORAX_ORE);
        blockWithItem(ModBlocks.FLUORITE_ORE);
        blockWithItem(ModBlocks.HALITE_ORE);
        blockWithItem(ModBlocks.DOLOMITE_ORE);
        blockWithItem(ModBlocks.BAUXITE_ORE);
        blockWithItem(ModBlocks.SILICA_ORE);
        blockWithItem(ModBlocks.APATITE_ORE);
        blockWithItem(ModBlocks.SULFUR_ORE);
        blockWithItem(ModBlocks.POTASH_ORE);
        blockWithItem(ModBlocks.LIMESTONE_ORE);
        blockWithItem(ModBlocks.THORTVEITITE_ORE);
        blockWithItem(ModBlocks.RUTILE_ORE);
        blockWithItem(ModBlocks.VANADINITE_ORE);
        blockWithItem(ModBlocks.CHROMITE_ORE);
        blockWithItem(ModBlocks.PYROLUSITE_ORE);
        blockWithItem(ModBlocks.COBALTITE_ORE);
        blockWithItem(ModBlocks.PENTLANDITE_ORE);
        blockWithItem(ModBlocks.SPHALERITE_ORE);
        blockWithItem(ModBlocks.ARSENOPYRITE_ORE);
        blockWithItem(ModBlocks.LEPIDOLITE_ORE);
        blockWithItem(ModBlocks.CELESTINE_ORE);
        blockWithItem(ModBlocks.MONAZITE_ORE);
        blockWithItem(ModBlocks.ZIRCON_ORE);
        blockWithItem(ModBlocks.COLUMBITE_ORE);
        blockWithItem(ModBlocks.MOLYBDENITE_ORE);
        blockWithItem(ModBlocks.ARGENTITE_ORE);
        blockWithItem(ModBlocks.CASSITERITE_ORE);
        blockWithItem(ModBlocks.STIBNITE_ORE);
        blockWithItem(ModBlocks.POLLUCITE_ORE);
        blockWithItem(ModBlocks.BARITE_ORE);
        blockWithItem(ModBlocks.TANTALITE_ORE);
        blockWithItem(ModBlocks.SCHEELITE_ORE);
        blockWithItem(ModBlocks.CINNABAR_ORE);
        blockWithItem(ModBlocks.GALENA_ORE);
        blockWithItem(ModBlocks.URANINITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
