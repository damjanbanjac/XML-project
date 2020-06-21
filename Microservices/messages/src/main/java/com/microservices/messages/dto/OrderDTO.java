package com.microservices.messages.dto;

import com.microservices.messages.model.AdCar;
import com.microservices.messages.model.Agent;
import com.microservices.messages.model.Order;
import com.microservices.messages.model.User;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Long id;
    private String availableFrom;
    private String availableTo;

    private AdCar adCar;
    //private Users user;
    //private Users userIzdao;
    //private Agent agentIzdao;


    public OrderDTO(Order order) {
        this.id=order.getId();
        this.availableFrom=order.getAvailableFrom();
        this.availableTo=order.getAvailableTo();
        this.adCar=order.getAdCar();
        //this.user=order.getUserr();
        //this.userIzdao=order.getUserIzdavao();
        //this.agentIzdao=order.getAgentIzdao();
    }
}