package com.microservices.maintenance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrandResponse {

    private Long id;

    private String name;

    private String label;
}
