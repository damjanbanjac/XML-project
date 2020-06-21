package com.microservices.search.repository;

import com.microservices.search.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarBrandRepository extends JpaRepository<CarBrand, Long> {

    CarBrand findOneById(long id);

    List<CarBrand> findAllByDeleted(boolean deleted);

}
