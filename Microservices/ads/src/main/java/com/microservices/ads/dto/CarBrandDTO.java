package com.microservices.ads.dto;

import com.microservices.ads.model.CarBrand;
import lombok.Data;

@Data
public class CarBrandDTO {
    private long id;


    public CarBrandDTO() {

    }

    public CarBrandDTO(CarBrand carBrand) {
        id = carBrand.getId();

    }
}
