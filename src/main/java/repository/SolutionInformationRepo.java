package repository;

import entity.SolutionInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionInformationRepo extends JpaRepository<SolutionInformation,Long>{

}
