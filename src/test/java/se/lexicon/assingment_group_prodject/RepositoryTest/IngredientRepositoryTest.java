package se.lexicon.assingment_group_prodject.RepositoryTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.assingment_group_prodject.Repository.IngredientRepository;
import se.lexicon.assingment_group_prodject.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class IngredientRepositoryTest {


    @Autowired
    IngredientRepository testObject;

    Ingredient createdIngredient;
    @BeforeEach
    public void setup(){
        Ingredient ingredientData = new Ingredient("Salt");
        createdIngredient = testObject.save(ingredientData);
        assertNotNull(createdIngredient);
    }


@Test
    public void testFindByIngredient(){
       Optional<Ingredient> ingredientOptional = testObject.findByIngredientName("Salt");
       assertTrue(ingredientOptional.isPresent());

       Ingredient actualData = ingredientOptional.get();
       Ingredient expectedData = createdIngredient;
       assertEquals(expectedData,actualData);
    }

    @Test
    public void testFindAllByIngredientNameContainsIgnoreCase(){
        List<Ingredient> actualData = testObject.findAllByIngredientNameContainsIgnoreCase("salt");

        List<Ingredient> expectedData = new ArrayList<>();
        expectedData.add(createdIngredient);

        assertEquals(expectedData, actualData);
    }
}
