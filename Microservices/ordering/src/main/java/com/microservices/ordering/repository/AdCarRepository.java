package com.microservices.ordering.repository;

import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCarRepository extends JpaRepository<AdCar, Long> {

    AdCar findOneById(long id);
}
