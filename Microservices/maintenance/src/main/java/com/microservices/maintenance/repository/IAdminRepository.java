package com.microservices.maintenance.repository;

import com.microservices.maintenance.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneById(Long id);
}
