package com.microservices.ads.dto;

import com.microservices.ads.model.CarBrand;
import lombok.Data;

@Data
public class CarBrandDTO {
    private long id;
    private String name;


    public CarBrandDTO() {

    }

    public CarBrandDTO(CarBrand carBrand) {
        id = carBrand.getId();
        name =carBrand.getName();
    }
}
