package com.microservices.ordering.repository;

import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findOneById(long id);
}
