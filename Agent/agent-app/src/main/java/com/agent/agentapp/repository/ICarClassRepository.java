package com.agent.agentapp.repository;

import com.agent.agentapp.entity.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarClassRepository extends JpaRepository<CarClass, Long> {

    CarClass findOneById(long id);

    List<CarClass> findAllByDeleted(boolean deleted);
}
