package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.entity.Report;
import lombok.Data;

@Data
public class ReportResponse {

   // private AdCar adCar;
    private Order order;
    private String text;
    private Integer km;

    public ReportResponse(Report report) {
       // adCar = report.getAdCar();
        order = report.getOrder();
        text = report.getText();
        km = report.getKm();
    }
}
