package se.lexicon.assingment_group_prodject.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.assingment_group_prodject.entity.Ingredient;

import java.util.Optional;

//
@DataJpaTest
public class IngredientRepositoryTest {
    @Autowired
    IngredientRepository testIngredient;

    Ingredient createdIngredient1;
    Ingredient createdIngredient2;

    @BeforeEach
    public void setup() {

        //create db for Ingredient
        Ingredient ingredient1 = new Ingredient("suger");
        Ingredient ingredient2 = new Ingredient("salt");
        createdIngredient1 = testIngredient.save(ingredient1);
        createdIngredient2 = testIngredient.save(ingredient2);
        assertNotNull(createdIngredient1);
        assertNotNull(createdIngredient2);
    }

    @Test
    public void test_findByNameEquals() {
        Optional<Ingredient> ingredientOptional = testIngredient.findByIngredientNameEquals(createdIngredient1.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData = createdIngredient1;
        assertEquals(expectedData,actualData);
    }
    @Test
    public void test_findByNameContaining() {
        Optional<Ingredient> ingredientOptional = testIngredient.findByIngredientNameContaining(createdIngredient2.getIngredientName());
        assertTrue(ingredientOptional.isPresent());
        Ingredient actualData = ingredientOptional.get();
        Ingredient expectedData = createdIngredient2;
        assertEquals(expectedData,actualData);
        System.out.println(ingredientOptional);
        System.out.println(createdIngredient2);
    }


}
