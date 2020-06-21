package com.agent.agentapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @Id
    @SequenceGenerator(name = "report_id_seq", sequenceName = "report_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_id_seq")
    private Long id;

    //@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    //private AdCar adCar;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Order order;
    private String text;
    private Integer km;

}