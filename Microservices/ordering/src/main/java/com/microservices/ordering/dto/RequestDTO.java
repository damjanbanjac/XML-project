package com.microservices.ordering.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RequestDTO {

    private  String status;
    private Date availableFrom;
    private Date availableTo;
    private Boolean bundle;
}
