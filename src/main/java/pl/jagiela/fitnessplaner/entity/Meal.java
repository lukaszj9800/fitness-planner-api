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
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<MealIngredient> ingredientsList;
    private double totalCalories;
    private double totalProtein;
    private double totalCarbs;
    private double totalFat;
    private String typeOfMeal;
    private String preparation;
    private String description;
    private boolean available = true;
    private Long idOwner;

}
