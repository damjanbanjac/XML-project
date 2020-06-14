package com.microservices.ads.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AgentAd")
public class Agent {

    @Id
    @SequenceGenerator(name = "agent_id_seq", sequenceName = "agent_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agent_id_seq")
    private Long id;

    private String name;

    private String address;

    private String pib;
}
