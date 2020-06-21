package com.microservices.search.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservices.search.model.*;
import lombok.Data;

import java.util.Date;
@Data
public class SearchAdDTO {

    private Long id;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarBrand carBrand;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarModel carModel;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FuelType fuelType;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private GearShiftType gearShiftType;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CarClass carClass;
    private Integer grade;
    private Integer kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;

    private String city;
    private Integer price;


    public SearchAdDTO() {

    }

    public SearchAdDTO(Long id, CarBrand carBrand, CarModel carModel, FuelType fuelType, GearShiftType gearBoxType, CarClass carClass, Integer grade, Integer kmRestriction, Integer kmTraveled, Boolean cdw, Integer kidsSeats, Date availableFrom, Date availableTo, String city, Integer price) {
        this.id = id;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.fuelType = fuelType;
        this.gearShiftType = gearBoxType;
        this.carClass = carClass;
        this.grade = grade;
        this.kmRestriction = kmRestriction;
        this.kmTraveled = kmTraveled;
        this.cdw = cdw;
        this.kidsSeats = kidsSeats;
        this.availableFrom = availableFrom;
        this.availableTo = availableTo;
        this.city = city;
        this.price = price;
    }

    public SearchAdDTO(SearchAd searchAd) {
        this.id = searchAd.getId();
        this.carClass = searchAd.getCarClass();
        this.carBrand = searchAd.getCarBrand();
        this.carModel = searchAd.getCarModel();
        this.kmRestriction = searchAd.getKmRestriction();
        this.grade = searchAd.getGrade();
        this.gearShiftType = searchAd.getGearShiftType();
        this.fuelType = searchAd.getFuelType();
        this.kmTraveled = searchAd.getKmTraveled();
        this.cdw = searchAd.getCdw();
        this.kidsSeats = searchAd.getKidsSeats();
        this.availableFrom = searchAd.getAvailableFrom();
        this.availableTo = searchAd.getAvailableTo();
        this.city = searchAd.getCity();
        this.price = searchAd.getPrice();
    }

}

