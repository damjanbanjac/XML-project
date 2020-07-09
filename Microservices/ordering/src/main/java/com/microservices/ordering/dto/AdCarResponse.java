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

    public AdCarResponse(Long id, long user, long agent, String from, String to) {
        this.id = id;
        this.userAd = user;
        this.agentAd = agent;
        this.availableFrom = from;
        this.availableTo = to;
    }
}