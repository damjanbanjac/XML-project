package com.microservices.authentication.dto.feignDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO {

    private Long id;

    private String name;

    private String email;

    private Boolean permissionBlocked;


    public AgentDTO(String email) {
        this.email = email;
    }
}
