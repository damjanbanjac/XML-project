package com.microservices.authentication.repository;

import com.microservices.authentication.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail( String email );
    User findOneById(Long id);
}