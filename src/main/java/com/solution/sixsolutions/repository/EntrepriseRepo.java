package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepo extends JpaRepository<Entreprise, Long> {

}
