package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.OneDayExercisesPlan;
import pl.jagiela.fitnessplaner.repository.OneDayExercisesPlanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OneDayExercisesPlanService {

    private final OneDayExercisesPlanRepository oneDayExercisesPlanRepository;

    public OneDayExercisesPlan saveNewSetOfExercise(OneDayExercisesPlan oneDayExercisesPlan) {
        OneDayExercisesPlan oneDayExercisesPlanToSave = oneDayExercisesPlanRepository.save(oneDayExercisesPlan);
        return oneDayExercisesPlanToSave;
    }

    public List<OneDayExercisesPlan> getAllSetOfExercises() {
        return oneDayExercisesPlanRepository.findAll();
    }
}
