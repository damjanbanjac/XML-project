package com.agent.agentapp.dto.request;

import lombok.Data;

@Data
public class GradeAdCarRequest {

    private float grade;

    private long adCarId;

    private long userId;
}
