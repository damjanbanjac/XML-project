package com.microservices.authentication.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private String email;
    private String name;
    private String surname;
    private String address;
    private String password;

}
