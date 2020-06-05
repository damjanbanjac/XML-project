package com.microservices.search.repository;

import com.microservices.search.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarClassRepository extends JpaRepository<CarClass, Long> {
}
