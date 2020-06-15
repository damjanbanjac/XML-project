package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Long> {

    Grade findOneById(long id);

    List<Grade> findAllByDeleted(boolean deleted);

    List<Grade> findAllByUserId(long id);

    List<Grade> findAllByAdCar_Id(long id);
}
