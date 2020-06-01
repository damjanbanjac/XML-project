package com.microservices.maintenance.repository;

import com.microservices.maintenance.entity.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarClassRepository extends JpaRepository<CarClass, Long> {

    CarClass findOneById(long id);

    List<CarClass> findAllByDeleted(boolean deleted);
}
