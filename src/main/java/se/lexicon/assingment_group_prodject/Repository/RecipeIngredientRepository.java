package se.lexicon.assingment_group_prodject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.assingment_group_prodject.entity.RecipeIngredient;
@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,Integer> {


}
