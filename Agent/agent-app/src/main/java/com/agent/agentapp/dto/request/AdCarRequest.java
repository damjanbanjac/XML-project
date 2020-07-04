package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.*;
import lombok.Data;

import java.util.Date;

@Data
public class AdCarRequest {

    private CarBrand carBrand_id;
    private CarClass carClass_id;
    //private User userAd;
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
    private String city;
}
