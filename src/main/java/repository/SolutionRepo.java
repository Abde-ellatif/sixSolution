package repository;

import entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepo extends JpaRepository<Solution, Long> {
}
