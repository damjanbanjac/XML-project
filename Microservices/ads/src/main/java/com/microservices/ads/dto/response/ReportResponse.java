package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Report;
import lombok.Data;

@Data
public class ReportResponse {

    private long order;
    private String text;
    private Integer km;

    public ReportResponse(Report report) {
        order = report.getOrders();
        text = report.getText();
        km = report.getKm();
    }
}
