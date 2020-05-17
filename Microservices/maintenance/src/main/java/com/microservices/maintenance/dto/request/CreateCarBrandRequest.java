package com.microservices.maintenance.dto.request;

import lombok.Data;

@Data
public class CreateCarBrandRequest {

    private String name;

    private String label;
}
