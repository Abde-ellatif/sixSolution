package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.RScientifique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RScientifiqueRepo extends JpaRepository<RScientifique, Long> {
}
