package com.microservices.ads.repository;

import com.microservices.ads.model.CarClass;
import com.microservices.ads.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
