package com.microservices.messages.model;

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
@Table(name = "AgentMessages")
public class Agent extends Person {

    @Id
    @SequenceGenerator(name = "users_id", sequenceName = "users_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id")
    private Long id;

    private String name;

    private String address;

    private String pib;
}