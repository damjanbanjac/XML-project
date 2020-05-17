package com.microservices.maintenance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfFuelResponse {

    private Long id;

    private String type;
}
