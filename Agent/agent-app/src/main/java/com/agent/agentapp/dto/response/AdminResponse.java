package com.agent.agentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {

    private long id;

    private String name;

    private String surname;

    private String email;

    private String phone_number;
}
