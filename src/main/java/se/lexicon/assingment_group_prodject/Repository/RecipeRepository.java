package se.lexicon.assingment_group_prodject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.assingment_group_prodject.entity.Recipe;
import se.lexicon.assingment_group_prodject.entity.RecipeCategory;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    List<Recipe> findAllByRecipeNameContaining(String recipeName);

    Optional<Recipe> findByRecipeName(String recipeName);



   Set<Recipe> findAllByCategoriesIsContaining(RecipeCategory category);

  /*  @Query("select a from Recipe a where a.categories = :Name")
Set<Recipe> findAllByCategoriesContaining(@Param("Name") List<RecipeCategory> categories);



   */

}
