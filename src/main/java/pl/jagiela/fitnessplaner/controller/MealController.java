package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.Meal;
import pl.jagiela.fitnessplaner.model.SaveMealRequest;
import pl.jagiela.fitnessplaner.service.MealService;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    @PostMapping("")
    public ResponseEntity<Meal> addNewMeal(@RequestBody SaveMealRequest saveMealRequest) {
        Meal meal = mealService.addNewMeal(saveMealRequest);
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    @GetMapping("")
    public ResponseEntity<List<Meal>> getAllMeals() {
        List<Meal> mealsList = mealService.getAllMeals();
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Meal> deleteMealBy(@PathVariable Long id) {
        Meal meal = mealService.findMealById(id);
        mealService.deleteMealById(id);
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    @GetMapping("/{typeOfMeal}")
    public ResponseEntity<List<Meal>> getMealsByTypeOfMeal(@PathVariable String typeOfMeal) {
        List<Meal> mealsList = mealService.findByTypeOfMeal(typeOfMeal);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Meal>> findMealsByName(@PathVariable String name) {
        List<Meal> mealsList = mealService.findMealsByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Meal> findMealById(@PathVariable Long id) {
        Meal meal = mealService.findMealById(id);
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    @GetMapping("/available/{available}/name/{name}")
    public ResponseEntity<List<Meal>> getMealsByAvailableAndName(@PathVariable boolean available, @PathVariable String name) {
        List<Meal> mealsList = mealService.getMealsByAvailableAndName(available, name);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @GetMapping("/available/{available}")
    public ResponseEntity<List<Meal>> getMealsByAvailable(@PathVariable boolean available) {
        List<Meal> mealsList = mealService.getMealsByAvailable(available);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @PostMapping("/changeFlag/{id}")
    public ResponseEntity<Meal> changeFlag(@PathVariable Long id) {
        Meal meal = mealService.changeFlag(id);
        return ResponseEntity.status(HttpStatus.OK).body(meal);
    }

    @GetMapping("/typeOfMeal/{typeOfMeal}/available/{available}")
    public ResponseEntity<List<Meal>> getMealsByTypeOfMealAndAvailable(@PathVariable String typeOfMeal, @PathVariable boolean available) {
        List<Meal> mealsList = mealService.getMealsByTypeOfMealAndAvailable(typeOfMeal, available);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

    @GetMapping("/idOwner/{idOwner}/available/{available}")
    public ResponseEntity<List<Meal>> getMealsByIdOwnerAndAvailable(@PathVariable Long idOwner, @PathVariable boolean available) {
        List<Meal> mealsList = mealService.getMealsByIdOwnerAndAvailable(idOwner, available);
        return ResponseEntity.status(HttpStatus.OK).body(mealsList);
    }

}
