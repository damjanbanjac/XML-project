package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.User;
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
