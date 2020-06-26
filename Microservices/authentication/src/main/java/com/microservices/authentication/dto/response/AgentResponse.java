package com.microservices.authentication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentResponse {

    private long id;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String pib;
    private String country;
    private String town;
    private Boolean blocked;
}
