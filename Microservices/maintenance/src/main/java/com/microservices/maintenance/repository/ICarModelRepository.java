package com.microservices.maintenance.repository;

import com.microservices.maintenance.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findOneById(Long id);

    List<CarModel> findAllByDeleted(boolean deleted);
}
