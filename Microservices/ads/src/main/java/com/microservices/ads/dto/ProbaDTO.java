package com.microservices.ads.dto;


import com.microservices.ads.model.CarBrand;
import com.microservices.ads.model.CarModel;
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
