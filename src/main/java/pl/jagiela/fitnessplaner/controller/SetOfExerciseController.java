package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.OneDayExercisesPlan;
import pl.jagiela.fitnessplaner.service.OneDayExercisesPlanService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/setOfExercise")
@RequiredArgsConstructor
public class SetOfExerciseController {

    private final OneDayExercisesPlanService oneDayExercisesPlanService;

    @PostMapping("")
    public ResponseEntity<OneDayExercisesPlan> saveNewSetOfExercise(@RequestBody OneDayExercisesPlan oneDayExercisesPlan) {
        OneDayExercisesPlan oneDayExercisesPlanToAdd = oneDayExercisesPlanService.saveNewSetOfExercise(oneDayExercisesPlan);
        return ResponseEntity.status(HttpStatus.OK).body(oneDayExercisesPlanToAdd);
    }

    @GetMapping("")
    public ResponseEntity<List<OneDayExercisesPlan>> getAllSetOfExercises() {
        List<OneDayExercisesPlan> oneDayExercisesPlans = oneDayExercisesPlanService.getAllSetOfExercises();
        return ResponseEntity.status(HttpStatus.OK).body(oneDayExercisesPlans);
    }

}
