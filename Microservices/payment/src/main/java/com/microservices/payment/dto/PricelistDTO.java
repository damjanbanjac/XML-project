package com.microservices.payment.dto;

import lombok.Data;

@Data
public class PricelistDTO {

    private String pricePerKm;
    private String priceForCDW;
    private String priceForWorkingDays;
    private String priceForWeekend;
}
