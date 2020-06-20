package com.microservices.ads.dto.response;

import com.microservices.ads.model.CarBrand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrandResponse {

    private long id;

    private String name;

    private String label;

    private boolean deleted;

    public CarBrandResponse(CarBrand c) {
       name = c.getName();
       label = c.getLabel();
       deleted = c.isDeleted();

    }
}
