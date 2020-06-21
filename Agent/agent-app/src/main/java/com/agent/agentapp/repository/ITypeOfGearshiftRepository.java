package com.agent.agentapp.repository;

import com.agent.agentapp.entity.TypeOfGearshift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeOfGearshiftRepository extends JpaRepository<TypeOfGearshift, Long> {

    TypeOfGearshift findOneById(Long id);

    List<TypeOfGearshift> findAllByDeleted(boolean deleted);
}
