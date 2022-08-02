package pl.jagiela.fitnessplaner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SaveMealRequest {

    private String name;
    private List<IngredientRequest> ingredientsRequestList;
    private String description;
    private String preparation;
    private String typeOfMeal;
    private Long idOwner;

}
