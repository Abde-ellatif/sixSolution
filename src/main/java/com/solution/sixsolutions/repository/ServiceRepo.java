package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Servicee, Long> {
}
