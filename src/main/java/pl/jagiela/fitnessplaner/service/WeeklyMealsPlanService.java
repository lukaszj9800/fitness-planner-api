package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.Meal;
import pl.jagiela.fitnessplaner.entity.OneDayMealsPlan;
import pl.jagiela.fitnessplaner.entity.WeeklyMealsPlan;
import pl.jagiela.fitnessplaner.model.SaveWeeklyMealsPlanRequest;
import pl.jagiela.fitnessplaner.repository.OneDayMealsPlanRepository;
import pl.jagiela.fitnessplaner.repository.WeeklyMealsPlanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeeklyMealsPlanService {

    private final WeeklyMealsPlanRepository weeklyMealsPlanRepository;
    private final OneDayMealsPlanRepository oneDayMealsPlanRepository;

    public WeeklyMealsPlan addNewWeeklyMealsPlan(SaveWeeklyMealsPlanRequest saveWeeklyMealsPlanRequest) {

        WeeklyMealsPlan weeklyMealsPlan = new WeeklyMealsPlan();
        String[] daysOfTheWeek = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
        int i = 0;

        List<List<Meal>> weeklyPlan = new ArrayList<>();
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getMondayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getTuesdayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getWednesdayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getThursdayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getFridayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getSaturdayMealsList());
        weeklyPlan.add(saveWeeklyMealsPlanRequest.getSundayMealsList());
        List<OneDayMealsPlan> oneDayMealsPlanList = new ArrayList<>();

        for (List<Meal> meal : weeklyPlan) {
            OneDayMealsPlan oneDayMealsPlanTmp = new OneDayMealsPlan();
            oneDayMealsPlanTmp.setListMealsOfTheDay(meal);
            oneDayMealsPlanTmp.setDayOfTheWeek(daysOfTheWeek[i]);
            oneDayMealsPlanRepository.save(oneDayMealsPlanTmp);
            oneDayMealsPlanList.add(oneDayMealsPlanTmp);
            i++;
        }

        weeklyMealsPlan.setIdOwner(saveWeeklyMealsPlanRequest.getIdOwner());
        weeklyMealsPlan.setOneDayMealsPlanList(oneDayMealsPlanList);
        weeklyMealsPlan.setName(saveWeeklyMealsPlanRequest.getName());

        return weeklyMealsPlanRepository.save(weeklyMealsPlan);
    }

    public List<WeeklyMealsPlan> getAllWeeklyMealsPlans() {
        return weeklyMealsPlanRepository.findAll();
    }

    public void deleteWeeklyMealsPlanById(Long id) {
        weeklyMealsPlanRepository.deleteById(id);
    }

    public WeeklyMealsPlan findWeeklyMealsPlanById(Long id) {
        return weeklyMealsPlanRepository.getById(id);
    }

    public List<WeeklyMealsPlan> findByIdOwner(Long idOwner) {
        return weeklyMealsPlanRepository.findByIdOwner(idOwner);
    }

    public List<WeeklyMealsPlan> getWeeklyMealsPlansByAvailable(boolean available) {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanRepository.findWeeklyMealsPlansByAvailable(available);
        return weeklyMealsPlans;
    }

    public List<WeeklyMealsPlan> getWeeklyMealsPlansByIdOwnerAndAvailable(Long idOwner, boolean available) {
        List<WeeklyMealsPlan> weeklyMealsPlans = weeklyMealsPlanRepository.findWeeklyMealsPlansByIdOwnerAndAvailable(idOwner, available);
        return weeklyMealsPlans;
    }

    public WeeklyMealsPlan changeFlag(Long id) {
        WeeklyMealsPlan weeklyMealsPlan = weeklyMealsPlanRepository.getById(id);
        if (weeklyMealsPlan.isAvailable()) {
            weeklyMealsPlan.setAvailable(false);
        } else {
            weeklyMealsPlan.setAvailable(true);
        }
        return weeklyMealsPlanRepository.save(weeklyMealsPlan);
    }
}
