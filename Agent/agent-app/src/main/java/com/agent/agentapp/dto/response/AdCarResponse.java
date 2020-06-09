package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.AdCar;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarResponse {
    private Long id;
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
    private  String city;

    public AdCarResponse(AdCar adCar) {
        id = adCar.getId();
        carBrand_id = adCar.getCarBrand_id().getId();
      //  userAd = adCar.getUserAd().getId();
        carModel_id = adCar.getCarModel_id().getId();
        fuelType_id = adCar.getFuelTypeCar_id().getId();
        gearShift_id = adCar.getGearShiftCar_id().getId();
        carClass_id = adCar.getCarClass_id().getId();
        grade = adCar.getGrade();
        kmRestriction = adCar.getKmRestriction();
        kmTraveled = adCar.getKmTraveled();
        cdw = adCar.getCdw();
        kidsSeats = adCar.getKidsSeats();
        availableFrom = adCar.getAvailableFrom();
        availableTo = adCar.getAvailableTo();
        city = adCar.getCity();
    }
}
