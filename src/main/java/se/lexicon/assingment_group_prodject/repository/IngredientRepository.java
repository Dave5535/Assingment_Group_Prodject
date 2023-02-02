package se.lexicon.assingment_group_prodject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.assingment_group_prodject.entity.Ingredient;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


    // "Search for one ingredient object that matches exactly with sent in ingredient name."
    @Query("select i from Ingredient i where i.ingredientName = :sugar")
    Optional<Ingredient> findByIngredientNameEquals(@Param("sugar") String ingredient);

    //" Search for ingredients that contains parts of sent in ingredient name. "
    @Query("select i from Ingredient i where i.ingredientName like '%al%'")
    Optional<Ingredient> findByIngredientNameContaining(@Param("al") String ingredient);

}
