package com.microservices.search.repository;

import com.microservices.search.model.TypeOfGearshift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearBoxTypeRepository extends JpaRepository<TypeOfGearshift,Long> {
}
