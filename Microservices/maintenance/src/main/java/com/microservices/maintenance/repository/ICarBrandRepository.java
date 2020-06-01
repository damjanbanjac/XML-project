package com.microservices.maintenance.repository;

import com.microservices.maintenance.entity.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarBrandRepository extends JpaRepository<CarBrand, Long> {

    CarBrand findOneById(long id);

    List<CarBrand> findAllByDeleted(boolean deleted);

}
