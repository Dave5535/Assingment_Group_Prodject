package se.lexicon.assingment_group_prodject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.assingment_group_prodject.entity.Ingredient;

import java.util.List;
import java.util.Optional;
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {

    Optional<Ingredient> findByIngredientName(String IngredientName);

    List<Ingredient> findAllByIngredientNameContainsIgnoreCase(String Name);


}
