package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Exercise;
import pl.jagiela.fitnessplaner.repository.ExerciseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Exercise addNewExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getAllExercises() {
        List<Exercise> exercisesList = exerciseRepository.findAll();
        return exercisesList;
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    public List<Exercise> getExercisesByLevelAndAvailable(String level, boolean available) {
        List<Exercise> exercisesList = exerciseRepository.getExercisesByLevelAndAvailable(level, available);
        return exercisesList;
    }

    public Exercise getExerciseById(Long id) {
        Exercise exercise = exerciseRepository.getById(id);
        return exercise;
    }

    public List<Exercise> getExercisesByIdOwnerAndAvailable(Long idOwner, boolean available) {
        List<Exercise> exercisesList = exerciseRepository.getExercisesByIdOwnerAndAvailable(idOwner, available);
        return exercisesList;
    }

    public List<Exercise> getExercisesByAvailable(boolean available) {
        List<Exercise> exercisesList = exerciseRepository.getExercisesByAvailable(available);
        return exercisesList;
    }


    public Exercise changeFlag(Long idToChange) {
        Exercise exercise = exerciseRepository.getById(idToChange);
        exercise.setId(idToChange);
        if (exercise.isAvailable()) {
            exercise.setAvailable(false);
        } else {
            exercise.setAvailable(true);
        }
        return exerciseRepository.save(exercise);
    }
}
