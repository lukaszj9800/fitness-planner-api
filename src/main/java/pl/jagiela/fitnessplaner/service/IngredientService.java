package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Ingredient;
import pl.jagiela.fitnessplaner.repository.IngredientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Ingredient addNewIngredient(Ingredient ingredient) {
        Ingredient ingredientToAdd = ingredientRepository.save(ingredient);
        return ingredientToAdd;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredientsList = ingredientRepository.findAll();
        return ingredientsList;
    }

    public List<Ingredient> getIngredientsByAvailable(boolean available) {
        List<Ingredient> ingredientsList = ingredientRepository.findIngredientsByAvailable(available);
        return ingredientsList;
    }

    public List<Ingredient> getIngredientsByAvailableAndName(boolean available, String name) {
        List<Ingredient> ingredientsList = ingredientRepository.findIngredientsByAvailableAndNameContainingIgnoreCase(available, name);
        return ingredientsList;
    }

    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }

    public Ingredient findIngredientById(Long id) {
        Ingredient ingredient = ingredientRepository.getById(id);
        return ingredient;
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredientDetails) {
        Ingredient ingredient = this.findIngredientById(id);
        ingredient.setId(id);
        ingredient.setName(ingredientDetails.getName());
        ingredient.setCalories(ingredientDetails.getCalories());
        ingredient.setUnit(ingredientDetails.getUnit());
        ingredient.setCarbs(ingredientDetails.getCarbs());
        ingredient.setFat(ingredientDetails.getFat());
        ingredient.setProtein(ingredientDetails.getProtein());
        return ingredientRepository.save(ingredient);
    }

    public List<Ingredient> findIngredientsByName(String name) {
        List<Ingredient> ingredientsList = ingredientRepository.findIngredientsByNameContainingIgnoreCase(name);
        return ingredientsList;
    }

    public Ingredient changeFlag(Long id) {
        Ingredient ingredient = ingredientRepository.getById(id);
        if (ingredient.isAvailable()) {
            ingredient.setAvailable(false);
        } else {
            ingredient.setAvailable(true);
        }
        return ingredientRepository.save(ingredient);
    }
}
