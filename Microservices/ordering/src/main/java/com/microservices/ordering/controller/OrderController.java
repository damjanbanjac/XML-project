package com.microservices.ordering.controller;


import com.microservices.ordering.dto.AdCarDTO;
import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.service.IOrderService;
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

    
    @PostMapping("/user/{id}")
    public OrderDTO createOrder(@RequestBody OrderDTO request, @PathVariable Long id) {
        return iorderService.createOrder(request, id);
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

    @GetMapping("/report")
    public List<OrderDTO> getAllOrdersForReport() throws Exception{
        return iorderService.getAllOrderForReport();
    }
}
