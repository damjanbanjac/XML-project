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

public class Pricelist {

    @Id
    @SequenceGenerator(name = "pricelist_id_seq", sequenceName = "pricelist_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pricelist_id_seq")
    private Long id;

    private String pricePerKm;
    private String priceForCDW;
    private String priceForWorkingDays;
    private String priceForWeekend;

}
