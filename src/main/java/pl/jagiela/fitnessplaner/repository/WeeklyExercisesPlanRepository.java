package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.WeeklyExercisesPlan;

import java.util.List;

@Repository
public interface WeeklyExercisesPlanRepository extends JpaRepository<WeeklyExercisesPlan, Long> {

    List<WeeklyExercisesPlan> findByIdOwner(Long idOwner);

    List<WeeklyExercisesPlan> findWeeklyExercisesPlanByAvailable(boolean available);

    List<WeeklyExercisesPlan> findWeeklyExercisesPlanByAvailableAndIdOwner(boolean available, Long idOwner);
}
