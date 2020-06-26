package com.microservices.authentication.dto.request;

import lombok.Data;

@Data
public class AgentRequest {

    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String pib;
    private String country;
    private String town;
    private Boolean active;
    private Boolean blocked;
    private String password;
}
