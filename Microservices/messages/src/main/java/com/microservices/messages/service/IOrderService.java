package com.microservices.messages.service;

import com.microservices.messages.dto.AdCarDTO;
import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.model.AdCar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface IOrderService {

    OrderDTO getOrder(long id);

    Set<OrderDTO> getAllOrders();

    OrderDTO createOrder(OrderDTO request);

    List<OrderDTO> getAllOrdersForUser(Long id);

    OrderDTO createPotrebno();

    List<AdCarDTO> getAllOglasi();

    List<AdCarDTO> getAgentsAds(Long agentId);

    List<AdCarDTO> getAd(AdCarDTO adCar);
}
