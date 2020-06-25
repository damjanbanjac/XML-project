package com.agent.agentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponse {

    private String email;

    private String name;

    private String surname;

    private Long id;

    private boolean blocked;
}
