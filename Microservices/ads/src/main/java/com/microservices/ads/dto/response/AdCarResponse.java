package com.microservices.ads.dto.response;

import com.microservices.ads.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarResponse {

    private CarBrand carBrand;
    private UserAd userAd;
    private CarModel carModel;
    private TypeOfFuel fuelType;
    private TypeOfGearshift gearBoxType;
    private CarClass carClass;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;

}
