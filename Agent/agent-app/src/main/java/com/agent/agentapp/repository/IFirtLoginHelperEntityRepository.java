package com.agent.agentapp.repository;

import com.agent.agentapp.entity.FirstLoginHelperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFirtLoginHelperEntityRepository extends JpaRepository<FirstLoginHelperEntity, Long> {

    FirstLoginHelperEntity findOneByEmail(String email);
}
