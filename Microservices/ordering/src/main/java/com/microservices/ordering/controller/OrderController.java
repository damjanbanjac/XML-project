package com.microservices.ordering.controller;


import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private IOrderService iorderService;


    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO request) {
        return iorderService.createOrder(request);
    }

    @GetMapping("/{id}/user")
    public List<OrderDTO> getAllOrdersForUser(@PathVariable Long id) {
        return iorderService.getAllOrdersForUser(id);
    }



}
