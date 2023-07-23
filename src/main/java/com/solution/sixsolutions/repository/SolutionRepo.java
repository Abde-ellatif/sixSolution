package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepo extends JpaRepository<Solution, Long> {
}
