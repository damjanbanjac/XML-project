package com.microservices.ads.repository;


import com.microservices.ads.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneById(Long id);
}
