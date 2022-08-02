package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.OneDayMealsPlan;
import pl.jagiela.fitnessplaner.repository.OneDayMealsPlanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OneDayMealsPlanService {

    private final OneDayMealsPlanRepository oneDayMealsPlanRepository;

    public OneDayMealsPlan addNewOneDayMealsPlan(OneDayMealsPlan oneDayMealsPlan) {
        return oneDayMealsPlanRepository.save(oneDayMealsPlan);
    }

    public List<OneDayMealsPlan> getAllOneDayMealsPlans() {
        return oneDayMealsPlanRepository.findAll();
    }


}
