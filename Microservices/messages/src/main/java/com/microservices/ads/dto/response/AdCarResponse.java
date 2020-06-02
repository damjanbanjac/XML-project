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

    public AdCarResponse(AdCar adCar) {
        carBrand = adCar.getCarBrand();
        userAd = adCar.getUserAd();
        carModel = adCar.getCarModel();
        fuelType = adCar.getFuelType();
        gearBoxType = adCar.getGearBoxType();
        carClass = adCar.getCarClass();
        grade = adCar.getGrade();
        kmRestriction = adCar.getKmRestriction();
        kmTraveled = adCar.getKmTraveled();
        cdw = adCar.getCdw();
        kidsSeats = adCar.getKidsSeats();
        availableFrom = adCar.getAvailableFrom();
        availableTo = adCar.getAvailableTo();
    }
}
