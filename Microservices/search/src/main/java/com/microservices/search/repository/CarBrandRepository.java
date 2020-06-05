package com.microservices.search.repository;

import com.microservices.search.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
}
