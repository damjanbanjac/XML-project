package com.agent.agentapp.dto.response;

import lombok.Data;

@Data
public class UserResponse {

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
