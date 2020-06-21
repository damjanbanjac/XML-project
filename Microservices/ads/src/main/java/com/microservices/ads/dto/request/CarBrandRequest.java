package com.microservices.ads.dto.request;

import lombok.Data;

@Data
public class CarBrandRequest {

    private long id;

    private String name;

    private String label;
}
