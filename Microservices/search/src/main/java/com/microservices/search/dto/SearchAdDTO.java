package com.microservices.search.dto;

import com.microservices.search.model.*;
import lombok.Data;

import java.util.Date;
@Data
public class SearchAdDTO {

    private Long id;
    private Long carBrand;
    private Long carModel;
    private Long fuelType;
    private Long gearBoxType;
    private Long carClass;
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

    public SearchAdDTO(Long id, Long carBrand, Long carModel, Long fuelType, Long gearBoxType, Long carClass, Integer grade, Integer kmRestriction, Integer kmTraveled, Boolean cdw, Integer kidsSeats, String availableFrom, String availableTo, String city, Integer price) {
        this.id = id;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.fuelType = fuelType;
        this.gearBoxType = gearBoxType;
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
        this.carClass = searchAd.getCarClass().getId();
        this.carBrand = searchAd.getCarBrand().getId();
        this.carModel = searchAd.getCarModel().getId();
        this.fuelType = searchAd.getFuelType().getId();
        this.gearBoxType = searchAd.getGearBoxType().getId();
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

