package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Personnelles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnellesRepo extends JpaRepository<Personnelles, Long> {
}
