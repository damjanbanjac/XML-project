package com.microservices.search.repository;

import com.microservices.search.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarClassRepository extends JpaRepository<CarClass, Long> {

    CarClass findOneById(long id);

    List<CarClass> findAllByDeleted(boolean deleted);

}
