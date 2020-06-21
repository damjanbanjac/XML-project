package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.utils.OrderRequestState;
import lombok.Data;

@Data
public class OrderResponse {

    private long id;
    private User user_id;
    private AdCar adCar_id;
   // private long adCar_id;
    private OrderRequestState state;
    private boolean deleted;
    private boolean usingTimeUp;

   public OrderResponse(Order order) {
        id = order.getId();
       // user_id = order.getUser();
        //adCar_id = order.getAdCar_id();
        state = order.getState();
        deleted = order.isDeleted();
        usingTimeUp = order.isUsingTimeUp();

    }
}
