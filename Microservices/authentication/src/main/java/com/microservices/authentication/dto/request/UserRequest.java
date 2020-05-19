package com.microservices.authentication.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String email;
    private String name;
    private String surname;
    private String address;
    private String password;

}
