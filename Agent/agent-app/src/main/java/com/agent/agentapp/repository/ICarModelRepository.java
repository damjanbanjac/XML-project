package com.agent.agentapp.repository;

import com.agent.agentapp.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findOneById(Long id);

    List<CarModel> findAllByDeleted(boolean deleted);
}
