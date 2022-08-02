package pl.jagiela.fitnessplaner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.jagiela.fitnessplaner.entity.Exercise;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaveWeeklyExercisesPlanRequest {

    private String name;
    private String description;
    private String level;
    private List<Exercise> mondayExercises;
    private List<Exercise> wednesdayExercises;
    private List<Exercise> fridayExercises;
    private Long idOwner;

}
