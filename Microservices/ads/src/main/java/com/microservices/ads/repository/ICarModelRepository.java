package com.microservices.ads.repository;

import com.microservices.ads.model.CarClass;
import com.microservices.ads.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findOneById(Long id);

    List<CarModel> findAllByDeleted(boolean deleted);
}
