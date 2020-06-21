package com.microservices.messages.repository;

import com.microservices.messages.model.AdCar;
import com.microservices.messages.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCarRepository extends JpaRepository<AdCar, Long> {

    AdCar findOneById(long id);
}