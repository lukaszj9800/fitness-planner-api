package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.Ingredient;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findIngredientsByNameContainingIgnoreCase(String name);

    List<Ingredient> findIngredientsByAvailable(boolean available);

    List<Ingredient> findIngredientsByAvailableAndNameContainingIgnoreCase(boolean available, String name);
}
