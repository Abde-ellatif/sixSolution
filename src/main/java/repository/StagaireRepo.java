package repository;

import entity.Stagaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagaireRepo extends JpaRepository<Stagaire,Long> {
    
}
