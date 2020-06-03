package com.microservices.ordering.dto;

import com.microservices.ordering.model.Order;
import com.microservices.ordering.model.Request;
import lombok.Data;

import java.util.List;

@Data
public class RequestDTO {

    private Long id;
    private  String status;
    private Boolean bundle;
    private List<Order> orderList;

    public RequestDTO(Request request) {
        this.id=request.getId();
        this.bundle=request.getBundle();
        this.status=request.getStatus();
        this.orderList=request.getOrderList();
    }

}
