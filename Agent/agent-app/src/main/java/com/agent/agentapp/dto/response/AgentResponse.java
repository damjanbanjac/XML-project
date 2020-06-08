package com.agent.agentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentResponse {

    private long id;

    private String name;

    private String address;

    private String pib;
}
