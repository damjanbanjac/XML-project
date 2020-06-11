package com.microservices.search.repository;

import com.microservices.search.model.GearShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearShiftTypeRepository extends JpaRepository<GearShiftType,Long> {
}
