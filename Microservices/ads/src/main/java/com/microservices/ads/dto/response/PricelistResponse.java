package com.microservices.ads.dto.response;

import com.microservices.ads.model.Pricelist;
import lombok.Data;

@Data
public class PricelistResponse {

    private Long id;

    private long agent;

    private long user;

    private String name;

    private Integer priceForWorkDay;

    private Integer priceForWeekend;

    private Integer priceForKmRestriction;

    private Integer priceForCDW;

    private  boolean deleted;

    public PricelistResponse(Pricelist pricelist) {
        id = pricelist.getId();
        agent =pricelist.getAgent();
        user =pricelist.getUser();
        name = pricelist.getName();
        priceForKmRestriction = pricelist.getPriceForKmRestriction();
        priceForCDW =pricelist.getPriceForCDW();
        priceForWeekend = pricelist.getPriceForWeekend();
        priceForWorkDay = pricelist.getPriceForWorkDay();
        deleted = pricelist.isDeleted();
    }
}
