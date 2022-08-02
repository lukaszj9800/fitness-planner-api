package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.WeeklyExercisesPlan;
import pl.jagiela.fitnessplaner.model.SaveWeeklyExercisesPlanRequest;
import pl.jagiela.fitnessplaner.service.WeeklyExercisesPlanService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/weeklyExercisesPlan")
@RequiredArgsConstructor
public class WeeklyExercisesPlanController {

    private final WeeklyExercisesPlanService weeklyExercisesPlanService;

    @PostMapping("")
    public ResponseEntity<WeeklyExercisesPlan> saveNewTraining(@RequestBody SaveWeeklyExercisesPlanRequest saveWeeklyExercisesPlanRequest) {
        WeeklyExercisesPlan weeklyExercisesPlan = weeklyExercisesPlanService.addNewWeeklyExercisesPlan(saveWeeklyExercisesPlanRequest);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlan);
    }

    @GetMapping("")
    public ResponseEntity<List<WeeklyExercisesPlan>> getAllTrainings() {
        List<WeeklyExercisesPlan> weeklyExercisesPlans = weeklyExercisesPlanService.getAllTrainings();
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlans);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<WeeklyExercisesPlan> getWeeklyExercisesPlanById(@PathVariable Long id) {
        WeeklyExercisesPlan weeklyExercisesPlan = weeklyExercisesPlanService.getWeeklyExercisesPlanById(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WeeklyExercisesPlan> deleteWeeklyExercisesPlanById(@PathVariable Long id) {
        WeeklyExercisesPlan weeklyExercisesPlan = weeklyExercisesPlanService.getWeeklyExercisesPlanById(id);
        weeklyExercisesPlanService.deleteWeeklyExercisesPlanById(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlan);
    }

    @GetMapping("/idOwner/{idOwner}")
    public ResponseEntity<List<WeeklyExercisesPlan>> findByIdOwner(@PathVariable Long idOwner) {
        List<WeeklyExercisesPlan> weeklyExercisesPlans = weeklyExercisesPlanService.findByIdOwner(idOwner);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlans);
    }

    @GetMapping("/available/{available}")
    public ResponseEntity<List<WeeklyExercisesPlan>> getWeeklyExercisesPlanByAvailable(@PathVariable boolean available) {
        List<WeeklyExercisesPlan> weeklyExercisesPlans = weeklyExercisesPlanService.getWeeklyExercisesByAvailable(available);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlans);
    }

    @GetMapping("/available/{available}/idOwner/{idOwner}")
    public ResponseEntity<List<WeeklyExercisesPlan>> getWeeklyExercisesPlanByAvailableAndIdOwner(@PathVariable boolean available, @PathVariable Long idOwner) {
        List<WeeklyExercisesPlan> weeklyExercisesPlans = weeklyExercisesPlanService.getWeeklyExercisesByAvailableAndIdOwner(available, idOwner);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlans);
    }

    @PostMapping("/changeFlag/{id}")
    public ResponseEntity<WeeklyExercisesPlan> changeFlag(@PathVariable Long id) {
        WeeklyExercisesPlan weeklyExercisesPlan = weeklyExercisesPlanService.changeFlag(id);
        return ResponseEntity.status(HttpStatus.OK).body(weeklyExercisesPlan);
    }

}
