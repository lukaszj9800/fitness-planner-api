package pl.jagiela.fitnessplaner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jagiela.fitnessplaner.entity.Exercise;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> getExercisesByLevelAndAvailable(String level, boolean available);

    List<Exercise> getExercisesByIdOwnerAndAvailable(Long idOwner, boolean available);

    List<Exercise> getExercisesByAvailable(boolean available);
}
