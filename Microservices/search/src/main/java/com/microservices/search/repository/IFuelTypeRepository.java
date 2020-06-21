package com.microservices.search.repository;

import com.microservices.search.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFuelTypeRepository extends JpaRepository<FuelType, Long> {

    FuelType findOneById(Long id);

    List<FuelType> findAllByDeleted(boolean deleted);
}
