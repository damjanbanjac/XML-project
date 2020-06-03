package com.microservices.ads.repository;

import com.microservices.ads.model.AdCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AdCarRepository extends JpaRepository<AdCar, Long> {
    AdCar findById(long id);

    AdCar findOneById(Long id);
}
