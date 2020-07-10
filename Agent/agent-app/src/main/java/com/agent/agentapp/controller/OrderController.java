package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.OrderDTO;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.dto.response.OrderResponse;
import com.agent.agentapp.service.IOrderService;
import com.agent.agentapp.service.implementation.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @Autowired
    private IOrderService iorderService;


    @PostMapping("/user/{id}")
    public OrderDTO createOrder(@RequestBody OrderDTO request, @PathVariable Long id) throws ParseException {
        return iorderService.createOrder(request, id);
    }

    @GetMapping("/{id}/user")
    public List<OrderDTO> getAllOrdersForUser(@PathVariable Long id) {
        return iorderService.getAllOrdersForUser(id);
    }

    /*
    @GetMapping("/ad")
    public List<AdCarDTO> getAd(@RequestBody AdCarDTO adCar){return iorderService.getAd(adCar);}*/
}
