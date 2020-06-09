package com.agent.agentapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private User userAd;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CarBrand carBrand_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CarModel carModel_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private TypeOfFuel fuelTypeCar_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private TypeOfGearshift gearShiftCar_id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Image> image;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CarClass carClass_id;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
    private String city;



}
