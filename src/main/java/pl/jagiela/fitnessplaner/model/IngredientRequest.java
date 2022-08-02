package pl.jagiela.fitnessplaner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.jagiela.fitnessplaner.entity.Ingredient;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class IngredientRequest {

    private Ingredient ingredient;
    private double amount;

}
