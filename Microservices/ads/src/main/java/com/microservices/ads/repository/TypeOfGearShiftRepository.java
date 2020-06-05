package com.microservices.ads.repository;

import com.microservices.ads.model.TypeOfGearshiftCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfGearShiftRepository extends JpaRepository<TypeOfGearshiftCar, Long> {
}
