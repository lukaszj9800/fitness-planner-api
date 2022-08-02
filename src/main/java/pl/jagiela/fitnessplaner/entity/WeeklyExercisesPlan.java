package pl.jagiela.fitnessplaner.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class WeeklyExercisesPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<OneDayExercisesPlan> oneDayExercisesPlans;
    private Long idOwner;
    private boolean available = true;

}
