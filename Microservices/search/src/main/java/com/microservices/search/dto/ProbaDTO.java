package com.microservices.search.dto;

import com.microservices.search.model.CarBrand;
import com.microservices.search.model.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProbaDTO {

    CarBrand carBrand;
    CarModel carModel;

    public ProbaDTO(CarBrand carBrand, CarModel carModel) {
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

}
