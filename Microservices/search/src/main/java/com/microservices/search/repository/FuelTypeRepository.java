package com.microservices.search.repository;

import com.microservices.search.model.TypeOfFuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<TypeOfFuel, Long> {
}
