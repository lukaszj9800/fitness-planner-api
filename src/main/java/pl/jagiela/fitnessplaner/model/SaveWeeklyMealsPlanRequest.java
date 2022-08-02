package pl.jagiela.fitnessplaner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.jagiela.fitnessplaner.entity.Meal;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaveWeeklyMealsPlanRequest {

    private String name;
    private List<Meal> mondayMealsList;
    private List<Meal> tuesdayMealsList;
    private List<Meal> wednesdayMealsList;
    private List<Meal> thursdayMealsList;
    private List<Meal> fridayMealsList;
    private List<Meal> saturdayMealsList;
    private List<Meal> sundayMealsList;
    private Long idOwner;

}
