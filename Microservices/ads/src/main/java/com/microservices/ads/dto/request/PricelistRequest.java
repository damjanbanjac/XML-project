package com.microservices.ads.dto.request;

import lombok.Data;

@Data
public class PricelistRequest {
    private Long id;

    private long agent;

    private long user;

    private String name;

    private Integer priceForWorkDay;

    private Integer priceForWeekend;

    private Integer priceForKmRestriction;

    private Integer priceForCDW;

    private  boolean deleted;
}
