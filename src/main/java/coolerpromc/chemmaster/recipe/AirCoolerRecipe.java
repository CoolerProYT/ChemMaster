package coolerpromc.chemmaster.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class AirCoolerRecipe implements Recipe<RecipeInput> {
    private final NonNullList<Ingredient> inputItems;
    private final List<ItemStack> output;
    private final ResourceLocation id;

    public AirCoolerRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, List<ItemStack> output) {
        this.id = id;
        this.inputItems = inputItems;
        this.output = output;
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        if(level.isClientSide()){
            return false;
        }

        //inputItems.get(0) is the first ingredient
        //pContainer.getItem(0) is the item in the first slot of the container
        return inputItems.get(0).test(recipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return AirCoolerRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return AirCoolerRecipe.Type.INSTANCE;
    }

    public NonNullList<Ingredient> getInputItems() {
        return inputItems;
    }

    public List<ItemStack> getOutputs() {
        return output;
    }

    public static class Type implements RecipeType<AirCoolerRecipe> {
        public static final AirCoolerRecipe.Type INSTANCE = new AirCoolerRecipe.Type();
        public static final String ID = "air_cooling";
    }

    public static class Serializer implements RecipeSerializer<AirCoolerRecipe>{
        public static final AirCoolerRecipe.Serializer INSTANCE = new AirCoolerRecipe.Serializer();
        public static final String ID = "air_cooling";

        public static final MapCodec<AirCoolerRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(AirCoolerRecipe::getInputItems),
                ItemStack.CODEC.listOf().fieldOf("output").forGetter(AirCoolerRecipe::getOutputs)
        ));

        @Override
        public MapCodec<AirCoolerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, AirCoolerRecipe> streamCodec() {
            return null;
        }
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return Recipe.super.getIngredients();
    }
}
