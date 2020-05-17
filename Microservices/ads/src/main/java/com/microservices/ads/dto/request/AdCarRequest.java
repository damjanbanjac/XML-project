package com.microservices.ads.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class AdCarRequest {

    private String carBrand;
    private String carModel;
    private String fuelType;
    private String gearBoxType;
    private String carClass;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
}
