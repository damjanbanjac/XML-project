package com.microservices.ads.dto.response;

import com.microservices.ads.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarResponse {

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

    public AdCarResponse(AdCar adCar) {
        carBrand_id = adCar.getCarBrand_id().getId();
        userAd = adCar.getUserAd().getId();
        carModel_id = adCar.getCarModel_id().getId();
//        fuelType_id = adCar.getFuelTypeCar_id().getId();
      //  gearShift_id = adCar.getGearShiftCar_id().getId();
        carClass_id = adCar.getCarClass_id().getId();
        grade = adCar.getGrade();
        kmRestriction = adCar.getKmRestriction();
        kmTraveled = adCar.getKmTraveled();
        cdw = adCar.getCdw();
        kidsSeats = adCar.getKidsSeats();
        availableFrom = adCar.getAvailableFrom();
        availableTo = adCar.getAvailableTo();
    }
}
