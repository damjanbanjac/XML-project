package com.microservices.search.dto;

import com.microservices.search.model.*;
import lombok.Data;

import java.util.Date;
@Data
public class SearchAdDTO {

    private long carBrand;
    private long carModel;
    private long fuelType;
    private long gearBoxType;
    private long carClass;
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
        this.carBrand = searchAd.getCarBrand().getId();
        this.carModel = searchAd.getCarModel().getId();
        this.fuelType = searchAd.getFuelType().getId();
        this.gearBoxType = searchAd.getGearBoxType().getId();
        this.carClass = searchAd.getCarClass().getId();
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

