package com.agent.agentapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private User userAd;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarBrand carBrand_id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarModel carModel_id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TypeOfFuel fuelTypeCar_id;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private TypeOfGearshift gearShiftCar_id;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Image> image;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private CarClass carClass_id;
    private Integer grade;
    private String kmRestriction;
    private Integer kmTraveled;
    private Boolean cdw;
    private  Integer kidsSeats;
    private Date availableFrom;
    private Date availableTo;
    private String city;

    @OneToMany(mappedBy = "adCar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "adCar", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

}
