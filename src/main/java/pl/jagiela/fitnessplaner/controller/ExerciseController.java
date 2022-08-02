package pl.jagiela.fitnessplaner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jagiela.fitnessplaner.entity.Exercise;
import pl.jagiela.fitnessplaner.service.ExerciseService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("")
    public ResponseEntity<Exercise> saveNewExercise(@RequestBody Exercise exercise) {
        Exercise exerciseToSave = exerciseService.addNewExercise(exercise);
        return ResponseEntity.status(HttpStatus.OK).body(exerciseToSave);
    }

    @GetMapping("")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exerciseList = exerciseService.getAllExercises();
        return ResponseEntity.status(HttpStatus.OK).body(exerciseList);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }

    @GetMapping("/level/{level}/available/{available}")
    public ResponseEntity<List<Exercise>> getExercisesByLevelAndAvailable(@PathVariable String level, @PathVariable boolean available) {
        List<Exercise> exercisesList = exerciseService.getExercisesByLevelAndAvailable(level, available);
        return ResponseEntity.status(HttpStatus.OK).body(exercisesList);
    }

    @PostMapping("/flag/{idToChange}")
    public ResponseEntity<Exercise> changeFlag(@PathVariable Long idToChange) {
        Exercise exercise = exerciseService.changeFlag(idToChange);
        return ResponseEntity.status(HttpStatus.OK).body(exercise);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) {
        Exercise exercise = exerciseService.getExerciseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(exercise);
    }

    @GetMapping("idOwner/{idOwner}/available/{available}")
    public ResponseEntity<List<Exercise>> findByOwnerId(@PathVariable Long idOwner, @PathVariable boolean available) {
        List<Exercise> exercisesList = exerciseService.getExercisesByIdOwnerAndAvailable(idOwner, available);
        return ResponseEntity.status(HttpStatus.OK).body(exercisesList);
    }

    @GetMapping("/available/{available}")
    public ResponseEntity<List<Exercise>> getExercisesByAvailable(@PathVariable boolean available) {
        List<Exercise> exercisesList = exerciseService.getExercisesByAvailable(available);
        return ResponseEntity.status(HttpStatus.OK).body(exercisesList);
    }

}
