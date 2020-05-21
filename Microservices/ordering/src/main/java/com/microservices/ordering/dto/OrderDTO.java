package com.microservices.ordering.dto;


import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Date availableFrom;
    private Date availableTo;

    private Long adCar;
    private Long User;

}
