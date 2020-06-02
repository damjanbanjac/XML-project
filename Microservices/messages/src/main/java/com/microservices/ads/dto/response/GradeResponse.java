package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class GradeResponse {

    private AdCar adCar;
    private Integer grade;
    // ko je dao ocenu
    private Long userId;

}
