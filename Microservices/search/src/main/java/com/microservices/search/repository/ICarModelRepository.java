package com.microservices.search.repository;

import com.microservices.search.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findOneById(Long id);

    List<CarModel> findAllByDeleted(boolean deleted);
}
