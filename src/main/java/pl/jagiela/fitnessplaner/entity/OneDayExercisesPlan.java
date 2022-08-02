package pl.jagiela.fitnessplaner.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OneDayExercisesPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dayOfTheWeek;
    private String level;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Exercise> exercisesList = new ArrayList<>();

}
