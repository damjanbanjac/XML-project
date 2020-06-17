package com.agent.agentapp.repository;

import com.agent.agentapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    Order findOneById(long id);

    List<Order> findAllByDeleted(boolean deleted);

    List<Order> findAllByUser_IdAndUsingTimeUp(long id, boolean usingTimeUp);
}
