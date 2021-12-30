package net.polarbear.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.polarbear.setup.Registration;

import java.util.function.Consumer;

public class NodeRecipes extends RecipeProvider {

    public NodeRecipes(DataGenerator dataGenerator){
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer){
        /**
         * Smelting Recipe:
         * Uses Node Ore Item
         * Gives: 1.0f (experience - default ingots)
         * Takes 100 ticks to smelt
         * */
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.NODE_ORE_ITEM),
                        Registration.NODE_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(Registration.NODE_ORE_ITEM))
                .save(consumer, "node_ingot1");

        /**
         * Smelting Recipe:
         * Uses Node Ore chunk
         * Gives: 0.0f (no experience)
         * Takes 100 ticks to smelt
         * */
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_NODE_CHUNK.get()),
                        Registration.NODE_INGOT.get(), 0.0f, 100)
                .unlockedBy("has_chunk", has(Registration.RAW_NODE_CHUNK.get()))
                .save(consumer, "node_ingot2");
    }

}
