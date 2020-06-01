package com.microservices.ads.model;

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
public class AdCar {

    @Id
    @SequenceGenerator(name = "ad_id_seq", sequenceName = "ad_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ad_id_seq")
    private Long id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarBrand carBrand;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarModel carModel;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TypeOfFuel fuelType;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TypeOfGearshift gearBoxType;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarClass carClass;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;


}
