package com.microservices.payment.model;

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
public class Discount {

    @Id
    @SequenceGenerator(name = "discount_id_seq", sequenceName = "discount_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_id_seq")
    private Long id;

    private String discount;

    //na koji oglas se odnosi popust
    //@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Long adCar;

    //na kog agenta se odnosi popust
    //@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Long Agent;


}
