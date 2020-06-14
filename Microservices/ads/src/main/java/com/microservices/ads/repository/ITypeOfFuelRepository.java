package com.microservices.ads.repository;

import com.microservices.ads.model.TypeOfFuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeOfFuelRepository extends JpaRepository<TypeOfFuel, Long> {

    TypeOfFuel findOneById(Long id);

    List<TypeOfFuel> findAllByDeleted(boolean deleted);
}