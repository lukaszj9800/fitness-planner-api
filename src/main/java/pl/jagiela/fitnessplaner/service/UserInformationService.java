package pl.jagiela.fitnessplaner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jagiela.fitnessplaner.entity.UserInformation;
import pl.jagiela.fitnessplaner.repository.UserInformationRepository;

@Service
@RequiredArgsConstructor
public class UserInformationService {

    private final UserInformationRepository userInformationRepository;

    public UserInformation addNewUserInformation(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }

    public UserInformation findUserInformationById(Long id) {
        return userInformationRepository.getById(id);
    }
}
