package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Order;
import com.microservices.ads.model.User;
import com.microservices.ads.utils.OrderRequestState;
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
