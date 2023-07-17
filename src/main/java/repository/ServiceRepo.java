package repository;

import entity.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Servicee, Long> {
}
