package pl.jagiela.fitnessplaner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterUserRequest {

    private String userName;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private double weight;
    private double height;
    private double age;
    private String gender;
    private double kcal;
    private String resolve;

}
