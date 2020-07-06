package com.microservices.search.dto;


import com.microservices.search.model.*;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



@Data
public class AdCarDTO {
    private Long id;
    private CarBrand carBrand_id;
    private CarClass carClass_id;
    private long userAd;
    private long agentAd;
    private CarModel carModel_id;
    private FuelType fuelType_id;
    private GearShiftType gearShift_id;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private String availableFrom;
    private String availableTo;
    private  String city;
    private int comments;
    private long pricelist;

    public AdCarDTO(SearchAd adCar) {
        id = adCar.getId();
        carBrand_id = adCar.getCarBrand();
        carModel_id = adCar.getCarModel();
        fuelType_id = adCar.getFuelType();
        gearShift_id = adCar.getGearShiftType();
        carClass_id = adCar.getCarClass();
        grade = adCar.getGrade();
        kmRestriction = Integer.toString(adCar.getKmRestriction());
        kmTraveled = adCar.getKmTraveled();
        cdw = adCar.getCdw();
        kidsSeats = adCar.getKidsSeats();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(adCar.getAvailableFrom());
        String strDate2 = dateFormat.format(adCar.getAvailableTo());
        availableFrom = strDate;
        availableTo = strDate2;
        city = adCar.getCity();

    }
}
