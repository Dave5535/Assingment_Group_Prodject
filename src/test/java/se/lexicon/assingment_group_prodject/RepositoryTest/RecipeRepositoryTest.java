package se.lexicon.assingment_group_prodject.RepositoryTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.assingment_group_prodject.Repository.RecipeCategoryRepository;
import se.lexicon.assingment_group_prodject.Repository.RecipeInstructionRepository;
import se.lexicon.assingment_group_prodject.Repository.RecipeRepository;
import se.lexicon.assingment_group_prodject.entity.*;

import java.util.*;

@DataJpaTest
public class RecipeRepositoryTest {
    @Autowired
    RecipeRepository testObject;
    @Autowired
    RecipeInstructionRepository instruction;
    @Autowired
    RecipeCategoryRepository categoryRepository;
    Recipe createdRecipe;
    RecipeInstruction createdInstruction;
    RecipeCategory createdCategory;
    RecipeIngredient createdIngredient;

    @BeforeEach
    public void setup() {
        Ingredient ingredient = new Ingredient("Flour");
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient, 2, Measurement.DL);
        List<RecipeIngredient> ingredientList = new ArrayList<>();
        ingredientList.add(recipeIngredient);
        RecipeInstruction recipeInstruction = new RecipeInstruction("testInstruction");
        RecipeCategory recipeCategory = new RecipeCategory("categoryTest");
        createdCategory = recipeCategory;

        Set<RecipeCategory> recipeCategories = new HashSet<>();
        recipeCategories.add(recipeCategory);
        Recipe recipe = new Recipe("Cake", ingredientList, recipeInstruction, recipeCategories);
        createdRecipe = testObject.save(recipe);
        assertNotNull(createdRecipe);
        System.out.println("#########################");


    }

    @Test
    public void TestFindAllByRecipeName() {

        List<Recipe> actualData = testObject.findAllByRecipeNameContaining("Cake");

        List<Recipe> expectedData = new ArrayList<>();
        expectedData.add(createdRecipe);

        assertEquals(expectedData, actualData);
    }

    @Test
    public void TestFindByNameContainingSpecifiedName() {
        Optional<Recipe> optionalRecipe = testObject.findByRecipeName("Cake");
        assertTrue(optionalRecipe.isPresent());
        Recipe actualData = optionalRecipe.get();
        Recipe expectedData = createdRecipe;
        assertEquals(expectedData, actualData);
    }

    @Test
    public void TestFindByCategory() {
/*
        Set<Recipe> actualData = testObject.findAllByCategoriesIsContaining(createdCategory);
        Set<Recipe> expectedData = new HashSet<>();
        expectedData.add(createdRecipe);
        assertEquals(expectedData, actualData);
*/

        }

    @Test
    public void TestFindByCategories() {
        System.out.println("#########################");

        List<RecipeCategory> arrOfCategories = new ArrayList<>();
        arrOfCategories.add(createdCategory);

        Set<Recipe> recipeSet = testObject.findAllByCategories(arrOfCategories);

        Optional <Recipe> recipeOptional = recipeSet.stream().findFirst();
        assertTrue(recipeOptional.isPresent());
        Recipe actualData = recipeOptional.get();

        System.out.println("#########################");
        Recipe expectedData = createdRecipe;

        assertEquals(expectedData, actualData);





    }
}
