package com.microservices.ads.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservices.ads.model.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarDTO {

    private Long id;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarBrand carBrand_id;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarModel carModel_id;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeOfFuel fuelType_id;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeOfGearshift gearShift_id;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarClass carClass_id;
    private Integer grade;
    private Integer kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;

    private String city;




    public AdCarDTO(AdCar searchAd) {
        this.id = searchAd.getId();
        this.carClass_id = searchAd.getCarClass_id();
        this.carBrand_id = searchAd.getCarBrand_id();
        this.carModel_id = searchAd.getCarModel_id();
        this.kmRestriction = Integer.parseInt(searchAd.getKmRestriction());
        this.grade = searchAd.getGrade();
        this.gearShift_id = searchAd.getGearShiftCar_id();
        this.fuelType_id = searchAd.getFuelTypeCar_id();
        this.kmTraveled = searchAd.getKmTraveled();
        this.cdw = searchAd.getCdw();
        this.kidsSeats = searchAd.getKidsSeats();
        this.availableFrom = searchAd.getAvailableFrom();
        this.availableTo = searchAd.getAvailableTo();
        this.city = searchAd.getCity();
//        this.price = searchAd.getPricelist();
    }

}


