package com.microservices.ordering.dto;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
public class AdCarResponse {

    private Long id;
    private long userAd;
    private long agentAd;
    private String availableFrom;
    private String availableTo;
}