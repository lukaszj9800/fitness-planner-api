package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Exercise;
import pl.jagiela.fitnessplaner.entity.OneDayExercisesPlan;
import pl.jagiela.fitnessplaner.entity.WeeklyExercisesPlan;
import pl.jagiela.fitnessplaner.model.SaveWeeklyExercisesPlanRequest;
import pl.jagiela.fitnessplaner.repository.OneDayExercisesPlanRepository;
import pl.jagiela.fitnessplaner.repository.WeeklyExercisesPlanRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeeklyExercisesPlanService {

    private final WeeklyExercisesPlanRepository weeklyExercisesPlanRepository;
    private final OneDayExercisesPlanRepository oneDayExercisesPlanRepository;
    private final EntityManager manager;

    @Transactional
    public WeeklyExercisesPlan addNewWeeklyExercisesPlan(SaveWeeklyExercisesPlanRequest saveWeeklyExercisesPlan) {
        WeeklyExercisesPlan weeklyExercisesPlan = new WeeklyExercisesPlan();
        String[] daysOfTheWeek = {"Poniedziałek", "Środa", "Piątek"};
        int i = 0;

        List<List<Exercise>> weeklyPlan = new ArrayList<>();
        weeklyPlan.add(saveWeeklyExercisesPlan.getMondayExercises());
        weeklyPlan.add(saveWeeklyExercisesPlan.getWednesdayExercises());
        weeklyPlan.add(saveWeeklyExercisesPlan.getFridayExercises());
        List<OneDayExercisesPlan> oneDayExercisesPlans = new ArrayList<>();

        for (List<Exercise> exercise : weeklyPlan) {
            OneDayExercisesPlan oneDayExercisesPlanTmp = new OneDayExercisesPlan();
            for (Exercise exercise1 : exercise) {
                oneDayExercisesPlanTmp.getExercisesList().add(manager.merge(exercise1));
            }
            oneDayExercisesPlanTmp.setDayOfTheWeek(daysOfTheWeek[i]);
            oneDayExercisesPlanTmp.setLevel(saveWeeklyExercisesPlan.getLevel());
            oneDayExercisesPlanRepository.save(oneDayExercisesPlanTmp);
            oneDayExercisesPlans.add(oneDayExercisesPlanTmp);
            i++;
        }

        weeklyExercisesPlan.setOneDayExercisesPlans(oneDayExercisesPlans);
        weeklyExercisesPlan.setName(saveWeeklyExercisesPlan.getName());
        weeklyExercisesPlan.setIdOwner(saveWeeklyExercisesPlan.getIdOwner());
        weeklyExercisesPlan.setDescription(saveWeeklyExercisesPlan.getDescription());

        return weeklyExercisesPlanRepository.save(weeklyExercisesPlan);
    }

    public List<WeeklyExercisesPlan> getAllTrainings() {
        return weeklyExercisesPlanRepository.findAll();
    }

    public List<WeeklyExercisesPlan> getWeeklyExercisesByAvailable(boolean available) {
        return weeklyExercisesPlanRepository.findWeeklyExercisesPlanByAvailable(available);
    }

    public WeeklyExercisesPlan getWeeklyExercisesPlanById(Long id) {
        return weeklyExercisesPlanRepository.getById(id);
    }

    public void deleteWeeklyExercisesPlanById(Long id) {
        weeklyExercisesPlanRepository.deleteById(id);
    }

    public List<WeeklyExercisesPlan> findByIdOwner(Long idOwner) {
        return weeklyExercisesPlanRepository.findByIdOwner(idOwner);
    }

    public List<WeeklyExercisesPlan> getWeeklyExercisesByAvailableAndIdOwner(boolean available, Long idOwner) {
        return weeklyExercisesPlanRepository.findWeeklyExercisesPlanByAvailableAndIdOwner(available, idOwner);
    }

    public WeeklyExercisesPlan changeFlag(Long id) {
        WeeklyExercisesPlan weeklyExercisesPlan = weeklyExercisesPlanRepository.getById(id);
        if (weeklyExercisesPlan.isAvailable()) {
            weeklyExercisesPlan.setAvailable(false);
        } else {
            weeklyExercisesPlan.setAvailable(true);
        }
        return weeklyExercisesPlanRepository.save(weeklyExercisesPlan);
    }

}
