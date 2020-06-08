package com.agent.agentapp.dto.request;

import lombok.Data;

@Data
public class UpdateAdminRequest {

    private String name;

    private String surname;

    private String email;

    private String phone_number;
}
