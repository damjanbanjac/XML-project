package com.microservices.search.dto;


import com.microservices.search.model.*;
import com.microservices.search.service.implementation.CarBrandService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdCarDTO {
    private Long id;
    private CarBrandDTO carBrand_id;
    private CarClassDTO carClass_id;
    private long userAd;
    private long agentAd;
    private CarModelDTO carModel_id;
    private FuelTypeDTO fuelType_id;
    private GearBoxTypeDTO gearShift_id;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
    private  String city;
    private int comments;
    private long pricelist;

    public AdCarDTO(SearchAd adCar) {
        id = adCar.getId();
        carBrand_id = new CarBrandDTO(adCar.getCarBrand());
        carModel_id = new CarModelDTO(adCar.getCarModel());
        fuelType_id = new FuelTypeDTO(adCar.getFuelType());
        gearShift_id = new GearBoxTypeDTO(adCar.getGearShiftType());
        carClass_id = new CarClassDTO(adCar.getCarClass());
        grade = adCar.getGrade();
        kmRestriction = Integer.toString(adCar.getKmRestriction());
        kmTraveled = adCar.getKmTraveled();
        cdw = adCar.getCdw();
        kidsSeats = adCar.getKidsSeats();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String strDate = dateFormat.format(adCar.getAvailableFrom());
//        String strDate2 = dateFormat.format(adCar.getAvailableTo());
//        availableFrom = strDate;
//        availableTo = strDate2;
        availableFrom = adCar.getAvailableFrom();
        availableTo = adCar.getAvailableTo();
        city = adCar.getCity();

    }
}
