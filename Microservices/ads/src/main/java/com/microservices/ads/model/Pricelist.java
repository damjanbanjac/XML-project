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
public class Pricelist {

    @Id
    @SequenceGenerator(name = "price_id", sequenceName = "price_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_id")
    private Long id;

    private long agent;

    private long user;

    private String name;

    private Integer priceForWorkDay;

    private Integer priceForWeekend;

    private Integer priceForKmRestriction;

    private Integer priceForCDW;

    private boolean deleted;



}
