package com.microservices.maintenance.dto.request;

import lombok.Data;

@Data
public class UpdateAgentRequest {

    private String name;

    private String surname;

    private String email;

    private String phone_number;
}
