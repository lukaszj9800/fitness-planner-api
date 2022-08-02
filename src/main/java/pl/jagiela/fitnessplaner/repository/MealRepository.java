package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.Meal;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findMealsByTypeOfMeal(String typeOfMeal);

    List<Meal> findMealsByNameContainingIgnoreCase(String name);

    List<Meal> findMealsByAvailable(boolean available);

    List<Meal> findMealsByAvailableAndNameContainingIgnoreCase(boolean available, String name);

    List<Meal> findMealsByTypeOfMealAndAvailable(String typeOfMeal, boolean available);

    List<Meal> findMealByIdOwnerAndAvailable(Long idOwner, boolean available);
}
