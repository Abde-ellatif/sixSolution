package com.solution.sixsolutions.repository;

import com.solution.sixsolutions.entity.Servicee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Servicee, Long> {
}
