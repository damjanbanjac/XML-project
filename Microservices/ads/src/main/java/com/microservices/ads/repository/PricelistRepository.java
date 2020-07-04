package com.microservices.ads.repository;


import com.microservices.ads.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricelistRepository extends JpaRepository<Pricelist, Long> {
    // AdCar findById(long id);

    Pricelist findOneById(Long id);
}

