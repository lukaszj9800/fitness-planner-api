package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.OneDayMealsPlan;
import pl.jagiela.fitnessplaner.service.OneDayMealsPlanService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/oneDayMealsPlan")
@RequiredArgsConstructor
public class OneDayMealsPlanController {

    private final OneDayMealsPlanService oneDayMealsPlanService;

    @PostMapping("")
    public ResponseEntity<OneDayMealsPlan> addNewOneDayMealsPlan(@RequestBody OneDayMealsPlan oneDayMealsPlan) {
        OneDayMealsPlan oneDayMealsPlanToAdd = oneDayMealsPlanService.addNewOneDayMealsPlan(oneDayMealsPlan);
        return ResponseEntity.status(HttpStatus.OK).body(oneDayMealsPlanToAdd);
    }

    @GetMapping("")
    public ResponseEntity<List<OneDayMealsPlan>> getAllOneDayMealsPlans() {
        List<OneDayMealsPlan> oneDayMealsPlansList = oneDayMealsPlanService.getAllOneDayMealsPlans();
        return ResponseEntity.status(HttpStatus.OK).body(oneDayMealsPlansList);
    }

}
