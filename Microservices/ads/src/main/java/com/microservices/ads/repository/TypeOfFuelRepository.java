package com.microservices.ads.repository;

import com.microservices.ads.model.CarClass;
import com.microservices.ads.model.TypeOfFuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfFuelRepository extends JpaRepository<TypeOfFuel, Long> {
}
