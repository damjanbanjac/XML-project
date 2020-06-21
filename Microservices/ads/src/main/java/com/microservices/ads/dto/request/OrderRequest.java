package com.microservices.ads.dto.request;

import com.microservices.ads.model.User;
import lombok.Data;

@Data
public class OrderRequest {

    private long id;
    private User user;
    private long adCar_id;
    private String state;
    private boolean deleted;
    private boolean usingTimeUp;
}
