package com.microservices.ads.repository;

import com.microservices.ads.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    Order findOneById(long id);

    List<Order> findAllByDeleted(boolean deleted);

    List<Order> findAllByUser_IdAndUsingTimeUp(long id, boolean usingTimeUp);
}
