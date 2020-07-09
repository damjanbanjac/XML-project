package com.microservices.ads.dto.response;

import lombok.Data;

@Data
public class OrderDTO {
    private Long id;
    private String availableFrom;
    private String availableTo;

    private Long adCar;
    private boolean deleted;
    //private Users user;
    private long user;
    //private Agent agentIzdao;


}
