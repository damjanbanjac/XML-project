package com.microservices.ordering.service;

import com.microservices.ordering.dto.OrderDTO;

import java.util.Set;

public interface OrderService {

    OrderDTO getOrder(long id);

    Set<OrderDTO> getAllOrders();

    OrderDTO createRequest(OrderDTO request);
}
