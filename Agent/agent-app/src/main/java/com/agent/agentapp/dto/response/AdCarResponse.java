package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarResponse {
    private Long id;
    private CarBrand carBrand_id;
    private CarClass carClass_id;
    private User userAd;
    private Agent agentAd;
    private CarModel carModel_id;
    private TypeOfFuel fuelType_id;
    private TypeOfGearshift gearShift_id;
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
        carBrand_id = adCar.getCarBrand_id();
      //  userAd = adCar.getUserAd().getId();
        agentAd = adCar.getAgentAd();
        carModel_id = adCar.getCarModel_id();
        fuelType_id = adCar.getFuelTypeCar_id();
        gearShift_id = adCar.getGearShiftCar_id();
        carClass_id = adCar.getCarClass_id();
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
