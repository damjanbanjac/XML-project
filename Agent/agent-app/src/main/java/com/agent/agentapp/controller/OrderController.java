package com.agent.agentapp.controller;

import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.dto.response.OrderResponse;
import com.agent.agentapp.service.implementation.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/report")
    public List<OrderResponse> getAllOrdersForReport() throws Exception{
        return orderService.getAllOrderForReport();
    }
}
