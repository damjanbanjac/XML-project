package com.microservices.ordering.dto;


import com.microservices.ordering.model.AdCar;
import com.microservices.ordering.model.Agent;
import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Date availableFrom;
    private Date availableTo;

    private AdCar adCar;
    private Users user;
    private Users userIzdao;
    private Agent agentIzdao;


    public OrderDTO(Order order) {
        this.availableFrom=order.getAvailableFrom();
        this.availableTo=order.getAvailableTo();
        this.adCar=order.getAdCar();
        this.user=order.getUserr();
        this.userIzdao=order.getUserIzdavao();
        this.agentIzdao=order.getAgentIzdao();
    }
}
