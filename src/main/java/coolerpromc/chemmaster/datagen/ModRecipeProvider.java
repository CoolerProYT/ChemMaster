package coolerpromc.chemmaster.datagen;

import coolerpromc.chemmaster.ChemMaster;
import coolerpromc.chemmaster.block.ModBlocks;
import coolerpromc.chemmaster.item.ModItems;
import coolerpromc.chemmaster.util.ModTag;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    /*private static final List<ItemLike> ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM.get(),
            ModBlocks.ALUMINUM_ORE.get());
    private static final List<ItemLike> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD.get(),
            ModBlocks.LEAD_ORE.get());*/

    public ModRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(p_248933_,pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        /*oreBlasting(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 100, "aluminum");
        oreSmelting(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 100, "aluminum");*/

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEST_TUBE.get(),3)
                .pattern("ABA")
                .pattern("A A")
                .pattern("AAA")
                .define('A', Items.GLASS_PANE)
                .define('B', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.GLASS_PANE), has(Items.GLASS_PANE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WATER_TUBE.get(),3)
                .requires(Items.WATER_BUCKET)
                .requires(ModItems.TEST_TUBE.get())
                .requires(ModItems.TEST_TUBE.get())
                .requires(ModItems.TEST_TUBE.get())
                .unlockedBy(getHasName(ModItems.TEST_TUBE.get()), has(ModItems.TEST_TUBE.get()))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pRecipeOutput, getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
