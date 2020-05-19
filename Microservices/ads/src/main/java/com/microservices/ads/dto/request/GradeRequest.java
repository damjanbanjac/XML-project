package com.microservices.ads.dto.request;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class GradeRequest {
    private AdCar adCar;
    private Integer grade;
    // ko je dao ocenu
    private Long userId;
}
