package com.microservices.ads.repository;

import com.microservices.ads.model.CarBrand;
import com.microservices.ads.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarBrandRepository extends JpaRepository<CarBrand, Long> {

    CarBrand findOneById(long id);

    List<CarBrand> findAllByDeleted(boolean deleted);

}
