package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import lombok.Data;

@Data
public class ReportRequest {

  //  private AdCar adCar;
    private Order order;
    private String text;
    private Integer km;

}