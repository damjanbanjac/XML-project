package com.microservices.ordering.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO2 {

    private Long id;

    private String name;

    private String email;

    private Boolean permissionBlocked;
}
