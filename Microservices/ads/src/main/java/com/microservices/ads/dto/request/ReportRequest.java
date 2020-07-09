package com.microservices.ads.dto.request;

import com.microservices.ads.dto.response.OrderDTO;
import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class ReportRequest {

    private OrderDTO order;
    private String text;
    private Integer km;

}
