package com.microservices.authentication.repository;

import com.microservices.authentication.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneById(Long id);
}
