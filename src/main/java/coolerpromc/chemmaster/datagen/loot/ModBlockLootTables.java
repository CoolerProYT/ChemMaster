package coolerpromc.chemmaster.datagen.loot;

import coolerpromc.chemmaster.block.ModBlocks;
import coolerpromc.chemmaster.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        /*this.dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ALUMINUM_BLOCK.get());
        this.add(ModBlocks.ALUMINUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get()));

        this.dropSelf(ModBlocks.LEAD_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LEAD_BLOCK.get());
        this.add(ModBlocks.LEAD_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get()));*/

        this.dropSelf(ModBlocks.FLUID_SEPARATOR.get());
        this.dropSelf(ModBlocks.ORE_PROCESSING_STATION.get());
        this.dropSelf(ModBlocks.AIR_COOLER.get());

        //temp
        this.dropSelf(ModBlocks.SPODUMENE_ORE.get());
        this.dropSelf(ModBlocks.BERYL_ORE.get());
        this.dropSelf(ModBlocks.BORAX_ORE.get());
        this.dropSelf(ModBlocks.FLUORITE_ORE.get());
        this.dropSelf(ModBlocks.HALITE_ORE.get());
        this.dropSelf(ModBlocks.DOLOMITE_ORE.get());
        this.dropSelf(ModBlocks.BAUXITE_ORE.get());
        this.dropSelf(ModBlocks.SILICA_ORE.get());
        this.dropSelf(ModBlocks.APATITE_ORE.get());
        this.dropSelf(ModBlocks.SULFUR_ORE.get());
        this.dropSelf(ModBlocks.POTASH_ORE.get());
        this.dropSelf(ModBlocks.LIMESTONE_ORE.get());
        this.dropSelf(ModBlocks.THORTVEITITE_ORE.get());
        this.dropSelf(ModBlocks.RUTILE_ORE.get());
        this.dropSelf(ModBlocks.VANADINITE_ORE.get());
        this.dropSelf(ModBlocks.CHROMITE_ORE.get());
        this.dropSelf(ModBlocks.PYROLUSITE_ORE.get());
        this.dropSelf(ModBlocks.COBALTITE_ORE.get());
        this.dropSelf(ModBlocks.PENTLANDITE_ORE.get());
        this.dropSelf(ModBlocks.SPHALERITE_ORE.get());
        this.dropSelf(ModBlocks.ARSENOPYRITE_ORE.get());
        this.dropSelf(ModBlocks.LEPIDOLITE_ORE.get());
        this.dropSelf(ModBlocks.CELESTINE_ORE.get());
        this.dropSelf(ModBlocks.MONAZITE_ORE.get());
        this.dropSelf(ModBlocks.ZIRCON_ORE.get());
        this.dropSelf(ModBlocks.COLUMBITE_ORE.get());
        this.dropSelf(ModBlocks.MOLYBDENITE_ORE.get());
        this.dropSelf(ModBlocks.ARGENTITE_ORE.get());
        this.dropSelf(ModBlocks.CASSITERITE_ORE.get());
        this.dropSelf(ModBlocks.STIBNITE_ORE.get());
        this.dropSelf(ModBlocks.POLLUCITE_ORE.get());
        this.dropSelf(ModBlocks.BARITE_ORE.get());
        this.dropSelf(ModBlocks.TANTALITE_ORE.get());
        this.dropSelf(ModBlocks.SCHEELITE_ORE.get());
        this.dropSelf(ModBlocks.CINNABAR_ORE.get());
        this.dropSelf(ModBlocks.GALENA_ORE.get());
        this.dropSelf(ModBlocks.URANINITE_ORE.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F,5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
