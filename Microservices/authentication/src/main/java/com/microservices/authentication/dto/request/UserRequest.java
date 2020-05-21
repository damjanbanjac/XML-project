package com.microservices.authentication.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String country;
    private String town;
    private Boolean active;
    private Boolean blocked;
    private Boolean permissionBlocked;
    private String rate;
    private String password;

}
