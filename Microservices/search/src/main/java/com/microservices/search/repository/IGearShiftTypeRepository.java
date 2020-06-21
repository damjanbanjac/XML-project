package com.microservices.search.repository;

import com.microservices.search.model.GearShiftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGearShiftTypeRepository extends JpaRepository<GearShiftType,Long> {

    GearShiftType findOneById(Long id);

    List<GearShiftType> findAllByDeleted(boolean deleted);
}
