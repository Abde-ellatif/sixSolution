package repository;

import dto.PersonnellesDto;
import entity.Personnelles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnellesRepo extends JpaRepository<Personnelles, Long> {
}
