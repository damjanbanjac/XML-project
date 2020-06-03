package com.microservices.ordering.service;

import com.microservices.ordering.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface IOrderService {

    OrderDTO getOrder(long id);

    Set<OrderDTO> getAllOrders();

    OrderDTO createOrder(OrderDTO request);

    List<OrderDTO> getAllOrdersForUser(Long id);
}
