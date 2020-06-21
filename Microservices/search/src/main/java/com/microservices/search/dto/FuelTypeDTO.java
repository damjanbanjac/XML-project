package com.microservices.search.dto;

import com.microservices.search.model.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelTypeDTO {

    private long id;

    private String type;

    public FuelTypeDTO(FuelType fuelType) {
        this.id = fuelType.getId();
        this.type = fuelType.getType();
    }
}