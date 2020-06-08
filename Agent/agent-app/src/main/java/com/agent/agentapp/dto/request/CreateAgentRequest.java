package com.agent.agentapp.dto.request;

import lombok.Data;

@Data
public class CreateAgentRequest {

    private String name;

    private String address;

    private String pib;
}
