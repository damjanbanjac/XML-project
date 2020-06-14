package com.microservices.ads.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfFuelResponse {

    private long id;

    private String type;
}
