package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.Ingredient;
import pl.jagiela.fitnessplaner.service.IngredientService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("")
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredientsList = ingredientService.getAllIngredients();
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsList);
    }

    @PostMapping("")
    public ResponseEntity<Ingredient> addNewIngredient(@RequestBody Ingredient ingredient) {
        Ingredient ingredientToAdd = ingredientService.addNewIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientToAdd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredient> deleteIngredientById(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        ingredientService.deleteIngredientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientService.updateIngredient(id, ingredientDetails);

        return ResponseEntity.status(HttpStatus.OK).body(ingredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> findIngredient(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ingredient);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Ingredient>> findIngredientsByName(@PathVariable String name) {
        List<Ingredient> ingredientsList = ingredientService.findIngredientsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(ingredientsList);
    }

    @PostMapping("/changeFlag/{id}")
    public ResponseEntity<Ingredient> changeFlag(@PathVariable Long id) {
        Ingredient ingredient = ingredientService.changeFlag(id);
        return ResponseEntity.status(HttpStatus.OK).body(ingredient);
    }

    @GetMapping("/available/{available}")
    public ResponseEntity<List<Ingredient>> getIngredientsByAvailable(@PathVariable boolean available) {
        List<Ingredient> ingredients = ingredientService.getIngredientsByAvailable(available);
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }

    @GetMapping("/available/{available}/name/{name}")
    public ResponseEntity<List<Ingredient>> getIngredientsByAvailableAndName(@PathVariable boolean available, @PathVariable String name) {
        List<Ingredient> ingredients = ingredientService.getIngredientsByAvailableAndName(available, name);
        return ResponseEntity.status(HttpStatus.OK).body(ingredients);
    }

}
