package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.response.OrderResponse;
import com.microservices.ads.model.Order;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    AdCarRepository adCarRepository;

    public List<OrderResponse> getAllOrderForReport() {

        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for(Order order : orders) {
            System.out.println(order.getAdCar_id().getKmTraveled());
            if(order.isUsingTimeUp() == true && order.isDeleted() == false) {
                System.out.println("usao u order");
                System.out.println(order.getAdCar_id());
                OrderResponse orderResponse = new OrderResponse(order);

                orderResponses.add(orderResponse);
            }
        }

            return  orderResponses;
    }
}