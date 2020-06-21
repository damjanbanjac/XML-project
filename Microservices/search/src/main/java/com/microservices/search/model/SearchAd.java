package com.microservices.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Table(name = "SearchAd")
    public class SearchAd {

        @Id
        @SequenceGenerator(name = "searchAd_id_seq", sequenceName = "searchAd_id_seq", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "searchAd_id_seq")
        private Long id;

        @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private CarBrand carBrand;
        @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
        private CarModel carModel;
        @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
        private FuelType fuelType;
        @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
        private GearShiftType gearShiftType;
        @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
        private CarClass carClass;
        private Integer grade;
        private Integer kmRestriction;
        private Integer kmTraveled;
        private Boolean cdw;
        private  Integer kidsSeats;
        private Date availableFrom;
        private Date availableTo;

        private String city;
        private Integer price;


    }

