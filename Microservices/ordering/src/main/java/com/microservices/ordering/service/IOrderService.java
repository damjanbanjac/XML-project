package com.microservices.ordering.service;

import com.microservices.ordering.dto.AdCarDTO;
import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.model.AdCar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface IOrderService {

    OrderDTO getOrder(long id);

    Set<OrderDTO> getAllOrders();

    OrderDTO createOrder(OrderDTO request, Long id);

    List<OrderDTO> getAllOrdersForUser(Long id);

    OrderDTO createPotrebno();

    List<AdCarDTO> getAllOglasi();

    List<AdCarDTO> getAgentsAds(Long agentId);

    List<AdCarDTO> getAd(AdCarDTO adCar);
}
