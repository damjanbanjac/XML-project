package com.microservices.ordering.model;

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
@Table(name="Orders")
public class Order {

    @Id
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    private Long id;

    private String availableFrom;
    private String availableTo;
    private Boolean required;
    private boolean deleted;

    //na koji oglas se odnosi zahtev
    //@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Long adCar;
    //na kog korisnika se odnosi zahtev
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Users userr;

    //koji korisnik je izdao oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Users userIzdavao;

    //koji agent je izdao oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Agent agentIzdao;
/*
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Request request;*/
}
