package com.microservices.ads.model;

import com.microservices.ads.dto.response.AdCarResponse;
import lombok.*;

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
    private UserAd userAd;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CarBrand carBrand_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private CarModel carModel_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private TypeOfFuelCar fuelTypeCar_id;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private TypeOfGearshiftCar gearShiftCar_id;

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


  /*  public AdCar(AdCarResponse carResponse) {
        userAd = carResponse.getUserAd();
        carBrand = carResponse.getCarBrand_id();
        carModel = carResponse.getCarModel();
        carClass = carResponse.getCarClass();
        availableTo = carResponse.getAvailableTo();
        availableFrom = carResponse.getAvailableFrom();
        kmTraveled = carResponse.getKmTraveled();
        cdw = carResponse.getCdw();
        kidsSeats = carResponse.getKidsSeats();
        fuelType = carResponse.getFuelType();
        gearBoxType = carResponse.getGearBoxType();
    } */
}
