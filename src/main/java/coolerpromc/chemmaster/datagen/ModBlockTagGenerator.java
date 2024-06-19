package coolerpromc.chemmaster.datagen;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.block.ModBlocks;
import coolerpromc.chemmaster.util.ModTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChemMaster.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                /*.add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.RAW_LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_ORE.get())*/
                .add(ModBlocks.FLUID_SEPARATOR.get())
                .add(ModBlocks.ORE_PROCESSING_STATION.get())
                .add(ModBlocks.AIR_COOLER.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                /*.add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.RAW_ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.RAW_LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_ORE.get())*/
                .add(ModBlocks.FLUID_SEPARATOR.get())
                .add(ModBlocks.ORE_PROCESSING_STATION.get())
                .add(ModBlocks.AIR_COOLER.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
//                .add(ModBlocks.ALUMINUM_BLOCK.get());
    }
}
