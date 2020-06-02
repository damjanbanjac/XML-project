package com.microservices.maintenance.repository;

import com.microservices.maintenance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);
}
