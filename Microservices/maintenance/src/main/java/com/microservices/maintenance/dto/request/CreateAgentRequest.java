package com.microservices.maintenance.dto.request;

import lombok.Data;

@Data
public class CreateAgentRequest {

    private String name;

    private String address;

    private String pib;
}
