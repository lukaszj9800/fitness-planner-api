package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.User;
import pl.jagiela.fitnessplaner.entity.UserInformation;
import pl.jagiela.fitnessplaner.model.RegisterUserRequest;
import pl.jagiela.fitnessplaner.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserInformationService userInformationService;

    public User addNewUser(RegisterUserRequest registerUserRequest) {
        User user = new User();
        UserInformation userInformation = new UserInformation();
        double tmpKcal = 0;
        double converter = 0;

        user.setUserName(registerUserRequest.getUserName());
        user.setPassword(registerUserRequest.getPassword());
        user.setEmail(registerUserRequest.getEmail());

        userInformation.setAge(registerUserRequest.getAge());
        userInformation.setFirstname(registerUserRequest.getFirstname());
        userInformation.setGender(registerUserRequest.getGender());
        userInformation.setHeight(registerUserRequest.getHeight());
        userInformation.setLastname(registerUserRequest.getLastname());
        userInformation.setPhone(registerUserRequest.getPhone());
        userInformation.setWeight(registerUserRequest.getWeight());
        userInformation.setResolve(registerUserRequest.getResolve());
        if (userInformation.getGender().equals("Mężczyzna")) {
            userInformation.setImgUrl("https://www.bootdey.com/img/Content/avatar/avatar7.png");
            tmpKcal = 66.5 + 13.5 * userInformation.getWeight() + 5 * userInformation.getHeight() - 6.5 * userInformation.getAge();
            if (userInformation.getResolve().equals("Chcę przytyć")) {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 6.5;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            } else if (userInformation.getResolve().equals("Chcę utrzymać wagę")) {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 5;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            } else {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 3.2;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            }
        } else {
            userInformation.setImgUrl("https://www.bootdey.com/img/Content/avatar/avatar8.png");
            tmpKcal = 655 + 9 * userInformation.getWeight() + 1.5 * userInformation.getHeight() - 4.6 * userInformation.getAge();
            if (userInformation.getResolve().equals("Chcę przytyć")) {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 6.5;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            } else if (userInformation.getResolve().equals("Chcę utrzymać wagę")) {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 5;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            } else {
                userInformation.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 3.2;
                tmpKcal += converter;
                userInformation.setKcal(tmpKcal);
            }
        }
        user.setUserInformation(userInformationService.addNewUserInformation(userInformation));
        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public String validateUserName(String userName) {
        System.out.println(userName);
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return "false";
        } else {
            return userName;
        }
    }

    public User updateUser(User user) {

        double tmpKcal = 0;
        double converter = 0;
        User userToUpdate = userRepository.getById(user.getId());
        UserInformation userInformationToUpdate = userInformationService.findUserInformationById(user.getUserInformation().getId());

        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());

        userInformationToUpdate.setFirstname(user.getUserInformation().getFirstname());
        userInformationToUpdate.setLastname(user.getUserInformation().getLastname());
        userInformationToUpdate.setResolve(user.getUserInformation().getResolve());
        userInformationToUpdate.setPhone(user.getUserInformation().getPhone());
        userInformationToUpdate.setWeight(user.getUserInformation().getWeight());
        userInformationToUpdate.setHeight(user.getUserInformation().getHeight());
        userInformationToUpdate.setAge(user.getUserInformation().getAge());
        userInformationToUpdate.setGender(user.getUserInformation().getGender());


        if (userInformationToUpdate.getGender().equals("Mężczyzna")) {
            userInformationToUpdate.setImgUrl("https://www.bootdey.com/img/Content/avatar/avatar7.png");
            tmpKcal = 66.5 + 13.5 * userInformationToUpdate.getWeight() + 5 * userInformationToUpdate.getHeight() - 6.5 * userInformationToUpdate.getAge();
            if (userInformationToUpdate.getResolve().equals("Chcę przytyć")) {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 6.5;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            } else if (userInformationToUpdate.getResolve().equals("Chcę utrzymać wagę")) {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 5;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            } else {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 3.2;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            }
        } else {
            userInformationToUpdate.setImgUrl("https://www.bootdey.com/img/Content/avatar/avatar8.png");
            tmpKcal = 655 + 9 * userInformationToUpdate.getWeight() + 1.5 * userInformationToUpdate.getHeight() - 4.6 * userInformationToUpdate.getAge();
            if (userInformationToUpdate.getResolve().equals("Chcę przytyć")) {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 6.5;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            } else if (userInformationToUpdate.getResolve().equals("Chcę utrzymać wagę")) {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 5;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            } else {
                userInformationToUpdate.setMinKcal(tmpKcal);
                converter = (tmpKcal / 10) * 3.2;
                tmpKcal += converter;
                userInformationToUpdate.setKcal(tmpKcal);
            }

        }

        userInformationService.addNewUserInformation(userInformationToUpdate);
        userToUpdate.setUserInformation(userInformationToUpdate);
        return userRepository.save(userToUpdate);
    }
}
