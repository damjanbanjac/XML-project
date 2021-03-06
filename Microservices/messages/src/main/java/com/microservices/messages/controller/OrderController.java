package com.microservices.messages.controller;

import com.microservices.messages.dto.AdCarDTO;
import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.model.AdCar;
import com.microservices.messages.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/potrebno")
    public OrderDTO createPotrebno(){return iorderService.createPotrebno();}

    @GetMapping("/oglasi")
    public List<AdCarDTO> getAllOglasi(){return iorderService.getAllOglasi();}

    @GetMapping("/oglasi/{agentId}")
    public List<AdCarDTO> getAgentsAds(@PathVariable Long agentId){return iorderService.getAgentsAds(agentId);}

    @GetMapping("/ad")
    public List<AdCarDTO> getAd(@RequestBody AdCarDTO adCar){return iorderService.getAd(adCar);}

}