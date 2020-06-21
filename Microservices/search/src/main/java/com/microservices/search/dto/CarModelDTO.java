package com.microservices.search.dto;

import com.microservices.search.model.CarModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarModelDTO {

    private long id;

    private String model;

    public CarModelDTO(CarModel carModel) {
        this.id = carModel.getId();
        this.model = carModel.getModel();
    }
}