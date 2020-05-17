package com.microservices.maintenance.dto.request;

import lombok.Data;

@Data
public class UpdateCarBrandRequest {

    private String name;

    private String label;
}
