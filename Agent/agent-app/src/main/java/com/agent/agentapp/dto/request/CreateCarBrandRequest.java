package com.agent.agentapp.dto.request;

import lombok.Data;

@Data
public class CreateCarBrandRequest {

    private long id;

    private String name;

    private String label;

    private boolean deleted;
}
