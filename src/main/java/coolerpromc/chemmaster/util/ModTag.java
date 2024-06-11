package coolerpromc.chemmaster.util;

import coolerpromc.chemmaster.ChemMaster;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTag {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_NETHERITE_TOOL = tag("needs_netherite_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(ChemMaster.MODID,name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(ChemMaster.MODID,name));
        }
    }
}
