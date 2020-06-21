package com.microservices.search.dto;

import com.microservices.search.model.CarBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrandDTO {

    private long id;

    private String name;

    private String label;



    public CarBrandDTO(CarBrand carBrand) {
        this.id = carBrand.getId();
        this.name = carBrand.getName();
        this.label = carBrand.getLabel();
    }

}
