package com.microservices.ads.repository;

import com.microservices.ads.model.CarBrand;
import com.microservices.ads.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarClassRepository extends JpaRepository<CarClass, Long> {
}
