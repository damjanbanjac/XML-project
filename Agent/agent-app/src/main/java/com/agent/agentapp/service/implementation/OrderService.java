package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.ReportRequest;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.dto.response.OrderResponse;
import com.agent.agentapp.dto.response.ReportResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Report;
import com.agent.agentapp.repository.AdCarRepository;
import com.agent.agentapp.repository.IOrderRepository;
import com.agent.agentapp.repository.ReportRepository;
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