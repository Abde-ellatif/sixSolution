package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepo extends JpaRepository<Personne, Long> {
}
