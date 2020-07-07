package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Request;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
