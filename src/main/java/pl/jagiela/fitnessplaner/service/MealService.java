package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Meal;
import pl.jagiela.fitnessplaner.entity.MealIngredient;
import pl.jagiela.fitnessplaner.model.SaveMealRequest;
import pl.jagiela.fitnessplaner.repository.MealIngredientRepository;
import pl.jagiela.fitnessplaner.repository.MealRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;
    private final MealIngredientRepository mealIngredientRepository;

    public Meal addNewMeal(SaveMealRequest saveMealRequest) {

        List<MealIngredient> mealIngredients = saveMealRequest.getIngredientsRequestList().stream()
                .map(ingredientRequest -> {
                    MealIngredient mealIngredient = new MealIngredient();
                    mealIngredient.setIngredient(ingredientRequest.getIngredient());
                    mealIngredient.setAmount(ingredientRequest.getAmount());
                    return mealIngredient;
                }).collect(Collectors.toList());

        for (MealIngredient mealIngredient : mealIngredients) {
            mealIngredientRepository.save(mealIngredient);
        }

        double tmpTotalCalories = 0;
        double tmpTotalCarbs = 0;
        double tmpTotalProtein = 0;
        double tmpTotalFat = 0;

        for (MealIngredient mealIngredient : mealIngredients) {
            if (mealIngredient.getIngredient().getUnit().equals("gram")) {
                tmpTotalCalories += (mealIngredient.getAmount() / 100) * (mealIngredient.getIngredient().getCalories());
                tmpTotalCarbs += (mealIngredient.getAmount() / 100) * (mealIngredient.getIngredient().getCarbs());
                tmpTotalFat += (mealIngredient.getAmount() / 100) * (mealIngredient.getIngredient().getFat());
                tmpTotalProtein += (mealIngredient.getAmount() / 100) * (mealIngredient.getIngredient().getProtein());
            } else if (mealIngredient.getIngredient().getUnit().equals("sztuk")) {
                tmpTotalCalories += (mealIngredient.getAmount()) * (mealIngredient.getIngredient().getCalories());
                tmpTotalCarbs += (mealIngredient.getAmount()) * (mealIngredient.getIngredient().getCarbs());
                tmpTotalFat += (mealIngredient.getAmount()) * (mealIngredient.getIngredient().getFat());
                tmpTotalProtein += (mealIngredient.getAmount()) * (mealIngredient.getIngredient().getProtein());
            }
        }

        Meal meal = new Meal();
        meal.setName(saveMealRequest.getName());
        meal.setIngredientsList(mealIngredients);
        meal.setTotalCalories(tmpTotalCalories);
        meal.setTotalCarbs(tmpTotalCarbs);
        meal.setTotalFat(tmpTotalFat);
        meal.setTotalProtein(tmpTotalProtein);
        meal.setDescription(saveMealRequest.getDescription());
        meal.setPreparation(saveMealRequest.getPreparation());
        meal.setTypeOfMeal(saveMealRequest.getTypeOfMeal());
        meal.setIdOwner(saveMealRequest.getIdOwner());

        return mealRepository.save(meal);
    }

    public List<Meal> getAllMeals() {
        List<Meal> mealsList = mealRepository.findAll();
        return mealsList;
    }

    public void deleteMealById(Long id) {
        Meal meal = mealRepository.getById(id);
        mealRepository.deleteById(id);
    }

    public List<Meal> findByTypeOfMeal(String typeOfMeal) {
        List<Meal> mealsList = mealRepository.findMealsByTypeOfMeal(typeOfMeal);
        return mealsList;
    }

    public List<Meal> findMealsByName(String name) {
        List<Meal> mealsList = mealRepository.findMealsByNameContainingIgnoreCase(name);
        return mealsList;
    }

    public Meal findMealById(Long id) {
        Meal meal = mealRepository.getById(id);
        return meal;
    }

    public List<Meal> getMealsByAvailable(boolean available) {
        List<Meal> meals = mealRepository.findMealsByAvailable(available);
        return meals;
    }

    public List<Meal> getMealsByAvailableAndName(boolean available, String name) {
        List<Meal> meals = mealRepository.findMealsByAvailableAndNameContainingIgnoreCase(available, name);
        return meals;
    }

    public List<Meal> getMealsByTypeOfMealAndAvailable(String typeOfMeal, boolean available) {
        List<Meal> meals = mealRepository.findMealsByTypeOfMealAndAvailable(typeOfMeal, available);
        return meals;
    }

    public List<Meal> getMealsByIdOwnerAndAvailable(Long idOwner, boolean available) {
        List<Meal> meals = mealRepository.findMealByIdOwnerAndAvailable(idOwner, available);
        return meals;
    }

    public Meal changeFlag(Long id) {
        Meal meal = mealRepository.getById(id);
        if (meal.isAvailable()) {
            meal.setAvailable(false);
        } else {
            meal.setAvailable(true);
        }
        return mealRepository.save(meal);
    }
}
