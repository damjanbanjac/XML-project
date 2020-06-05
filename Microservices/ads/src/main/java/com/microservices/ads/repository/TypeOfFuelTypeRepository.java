package com.microservices.ads.repository;

import com.microservices.ads.model.TypeOfFuelCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfFuelTypeRepository extends JpaRepository<TypeOfFuelCar, Long> {
}
