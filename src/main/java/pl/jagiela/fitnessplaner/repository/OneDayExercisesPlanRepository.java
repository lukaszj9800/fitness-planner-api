package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.OneDayExercisesPlan;

@Repository
public interface OneDayExercisesPlanRepository extends JpaRepository<OneDayExercisesPlan, Long> {
}
