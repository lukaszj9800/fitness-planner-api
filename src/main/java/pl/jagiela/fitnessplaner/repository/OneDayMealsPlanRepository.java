package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.OneDayMealsPlan;

@Repository
public interface OneDayMealsPlanRepository extends JpaRepository<OneDayMealsPlan, Long> {
}
