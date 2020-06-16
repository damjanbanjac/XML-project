package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Report;
import lombok.Data;

@Data
public class ReportResponse {

    private AdCar adCar;
    private String text;
    private Integer km;

    public ReportResponse(Report report) {
        adCar = report.getAdCar();
        text = report.getText();
        km = report.getKm();
    }
}
