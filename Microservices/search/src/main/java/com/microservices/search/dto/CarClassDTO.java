package com.microservices.search.dto;

import com.microservices.search.model.CarClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarClassDTO {

    private long id;

    private String car_class;


    public CarClassDTO(CarClass carClass) {
        this.id = carClass.getId();
        this.car_class = carClass.getCar_class();
    }
}