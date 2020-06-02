package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class ReportResponse {

    private AdCar adCar;
    private String text;
    private Integer km;
}
