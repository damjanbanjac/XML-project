package com.microservices.ordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @SequenceGenerator(name = "request_id_seq", sequenceName = "request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_id_seq")
    private Long id;

    private Date availableFrom;
    private Date availableTo;

    //na koji oglas se odnosi zahtev
    //@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Long adCar;
    //na kog korisnika se odnosi zahtev
    //@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Long User;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Request request;
}
