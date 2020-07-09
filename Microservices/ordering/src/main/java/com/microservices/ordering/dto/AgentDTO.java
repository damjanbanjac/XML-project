package com.microservices.ordering.dto;

import com.microservices.ordering.model.Agent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentDTO {

    private long id;

    private String name;

    private String adress;

    private String pib;



    public AgentDTO(Agent agent) {
        this.id = agent.getId();
        this.name = agent.getName();
        this.adress = agent.getAddress();
        this.pib = agent.getPib();
    }

}
