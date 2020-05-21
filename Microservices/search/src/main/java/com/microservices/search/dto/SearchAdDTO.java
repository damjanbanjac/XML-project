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
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
}
