package com.microservices.search.model;

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
@Table(name = "CarBrandSearchAd")
public class CarBrand {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;

//    @OneToMany(fetch = FetchType.LAZY)
////    @JoinColumn(name = "carBrand")
////    public List<SearchAd> adsCar;

    private String name;

    private String label;

    private boolean deleted;
}
