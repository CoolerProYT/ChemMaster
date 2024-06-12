package coolerpromc.chemmaster.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FluidSeparatingRecipe implements Recipe<SimpleContainer> {
    private final NonNullList<Ingredient> inputItems;
    private final List<ItemStack> output;
    private final ResourceLocation id;

    public FluidSeparatingRecipe(ResourceLocation id, NonNullList<Ingredient> inputItems, List<ItemStack> output) {
        this.id = id;
        this.inputItems = inputItems;
        this.output = output;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }

        //inputItems.get(0) is the first ingredient
        //pContainer.getItem(0) is the item in the first slot of the container
        return inputItems.get(0).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public NonNullList<Ingredient> getInputItems() {
        return inputItems;
    }

    public List<ItemStack> getOutputs() {
        return output;
    }

    public static class Type implements RecipeType<FluidSeparatingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "fluid_separating";
    }

    public static class Serializer implements RecipeSerializer<FluidSeparatingRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation("chemmaster:fluid_separating");

        @Override
        public FluidSeparatingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            JsonArray outputArray = GsonHelper.getAsJsonArray(pSerializedRecipe, "output");
            List<ItemStack> outputs = new ArrayList<>();

            for (JsonElement element : outputArray) {
                outputs.add(ShapedRecipe.itemStackFromJson(element.getAsJsonObject()));
            }

            return new FluidSeparatingRecipe(pRecipeId, inputs, outputs);
        }


        @Override
        public @Nullable FluidSeparatingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            int outputCount = pBuffer.readInt();
            List<ItemStack> outputs = new ArrayList<>();

            for (int i = 0; i < outputCount; i++) {
                outputs.add(pBuffer.readItem());
            }

            return new FluidSeparatingRecipe(pRecipeId, inputs, outputs);
        }


        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, FluidSeparatingRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.inputItems.size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }

            List<ItemStack> outputs = pRecipe.output;
            pBuffer.writeInt(outputs.size());

            for (ItemStack output : outputs) {
                pBuffer.writeItem(output);
            }
        }

    }
}
