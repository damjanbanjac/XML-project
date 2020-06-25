package com.microservices.authentication.repository;

import com.microservices.authentication.model.FirstLoginHelperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFirstLoginHelperEntityRepository extends JpaRepository<FirstLoginHelperEntity, Long> {

    FirstLoginHelperEntity findOneByEmail(String email);
}
