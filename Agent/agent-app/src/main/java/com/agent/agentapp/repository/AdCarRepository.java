package com.agent.agentapp.repository;

import com.agent.agentapp.entity.AdCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdCarRepository extends JpaRepository<AdCar, Long> {

    AdCar findOneById(Long id);
}