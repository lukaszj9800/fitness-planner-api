package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.WeeklyMealsPlan;
import pl.jagiela.fitnessplaner.model.SaveWeeklyMealsPlanRequest;
import pl.jagiela.fitnessplaner.service.WeeklyMealsPlanService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/weeklyMealsPlan")
@RequiredArgsConstructor
public class WeeklyMealsPlanController {

    private final WeeklyMealsPlanService weeklyMealsPlanService;

    @PostMapping("")
    public ResponseEntity<WeeklyMealsPlan> addNewWeeklyMealsPlan(@RequestBody SaveWeeklyMealsPlanRequest saveWeeklyMealsPlanRequest) {
        WeeklyMealsPlan weeklyMealsPlan = weeklyMealsPlanService.addNewWeeklyMealsPlan(saveWeeklyMealsPlanRequest);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlan);
    }

    @GetMapping("")
    public ResponseEntity<List<WeeklyMealsPlan>> getAllWeeklyMealsPlans() {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanService.getAllWeeklyMealsPlans();
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlans);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WeeklyMealsPlan> deleteWeeklyMealsPlanById(@PathVariable Long id) {
        WeeklyMealsPlan weeklyMealsPlan = weeklyMealsPlanService.findWeeklyMealsPlanById(id);
        weeklyMealsPlanService.deleteWeeklyMealsPlanById(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeeklyMealsPlan> getWeeklyMealsPlanById(@PathVariable Long id) {
        WeeklyMealsPlan weeklyMealsPlan = weeklyMealsPlanService.findWeeklyMealsPlanById(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlan);
    }

    @GetMapping("/idOwner/{idOwner}")
    public ResponseEntity<List<WeeklyMealsPlan>> findByIdOwner(@PathVariable Long idOwner) {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanService.findByIdOwner(idOwner);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlans);
    }

    @GetMapping("/available/{available}")
    public ResponseEntity<List<WeeklyMealsPlan>> getWeeklyMealsPlansByAvailable(@PathVariable boolean available) {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanService.getWeeklyMealsPlansByAvailable(available);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlans);
    }

    @GetMapping("/idOwner/{idOwner}/available/{available}")
    public ResponseEntity<List<WeeklyMealsPlan>> getWeeklyMealsPlansByIdOwnerAndAvailable(@PathVariable Long idOwner, @PathVariable boolean available) {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanService.getWeeklyMealsPlansByIdOwnerAndAvailable(idOwner, available);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlans);
    }

    @PostMapping("/changeFlag/{id}")
    public ResponseEntity<WeeklyMealsPlan> changeFlag(@PathVariable Long id) {
        WeeklyMealsPlan weeklyMealsPlan = weeklyMealsPlanService.changeFlag(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyMealsPlan);
    }

}
