package com.agent.agentapp.repository;


import com.agent.agentapp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {

    Admin findOneById(Long id);
}
