package com.microservices.ads.dto.request;

import com.microservices.ads.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarRequest {

    private long carBrand_id;
    private long carClass_id;
    private long userAd;
    private long carModel_id;
    private long fuelType_id;
    private long gearShift_id;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
}
