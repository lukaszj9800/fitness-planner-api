package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
}
