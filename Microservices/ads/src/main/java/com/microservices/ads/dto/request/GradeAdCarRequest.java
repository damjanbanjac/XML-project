package com.microservices.ads.dto.request;

import lombok.Data;

@Data
public class GradeAdCarRequest {

    private float grade;

    private long adCarId;

    private long userId;
}
