package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.WeeklyMealsPlan;

import java.util.List;

@Repository
public interface WeeklyMealsPlanRepository extends JpaRepository<WeeklyMealsPlan, Long> {

    List<WeeklyMealsPlan> findByIdOwner(Long idOwner);

    List<WeeklyMealsPlan> findWeeklyMealsPlansByIdOwnerAndAvailable(Long idOwner, boolean available);

    List<WeeklyMealsPlan> findWeeklyMealsPlansByAvailable(boolean available);

}
