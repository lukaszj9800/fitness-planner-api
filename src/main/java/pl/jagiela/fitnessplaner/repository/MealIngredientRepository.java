package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.MealIngredient;

@Repository
public interface MealIngredientRepository extends JpaRepository<MealIngredient, Long> {
}
