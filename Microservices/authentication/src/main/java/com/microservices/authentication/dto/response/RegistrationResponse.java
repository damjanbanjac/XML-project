package com.microservices.authentication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {

    private Long id;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String country;
    private String town;
    private Boolean blocked;
}
