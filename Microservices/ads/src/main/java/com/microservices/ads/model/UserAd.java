package com.microservices.ads.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAd {

    @Id
    @SequenceGenerator(name = "userad_id_seq", sequenceName = "userad_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userad_id_seq")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userAd")
    public List<AdCar> adsCar;
}
