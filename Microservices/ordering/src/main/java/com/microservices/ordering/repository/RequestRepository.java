package com.microservices.ordering.repository;

import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Request findOneById(long id);
}
