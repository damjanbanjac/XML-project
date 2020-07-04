package com.agent.agentapp.service;

import com.agent.agentapp.dto.request.OrderDTO;

import java.text.ParseException;
import java.util.List;

public interface IOrderService {

    OrderDTO createOrder(OrderDTO request) throws ParseException;

    List<OrderDTO> getAllOrdersForUser(Long id);
}
