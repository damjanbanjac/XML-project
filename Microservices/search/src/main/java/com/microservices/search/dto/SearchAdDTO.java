package com.microservices.search.dto;

import com.microservices.search.model.*;
import lombok.Data;

import java.util.Date;
@Data
public class SearchAdDTO {

    private CarBrand carBrand;
    private CarModel carModel;
    private TypeOfFuel fuelType;
    private TypeOfGearshift gearBoxType;
    private CarClass carClass;
    private Integer grade;
    private Integer kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private String availableFrom;
    private String availableTo;

    private String city;
    private Integer price;


    public SearchAdDTO() {

    }

    public SearchAdDTO(SearchAd searchAd) {
        this.carBrand = searchAd.getCarBrand();
        this.carModel = searchAd.getCarModel();
        this.fuelType = searchAd.getFuelType();
        this.gearBoxType = searchAd.getGearBoxType();
        this.carClass = searchAd.getCarClass();
        this.grade = searchAd.getGrade();
        this.kmRestriction = searchAd.getKmRestriction();
        this.kmTraveled = searchAd.getKmTraveled();
        this.cdw = searchAd.getCdw();
        this.kidsSeats = searchAd.getKidsSeats();
        this.availableFrom = searchAd.getAvailableFrom();
        this.availableTo = searchAd.getAvailableTo();
        this.city = searchAd.getCity();
        this.price = searchAd.getPrice();
    }

}

