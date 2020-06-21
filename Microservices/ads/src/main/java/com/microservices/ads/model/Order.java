package com.microservices.ads.model;

import com.microservices.ads.utils.OrderRequestState;
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
@Table(name="OrderAd")
public class Order {

    @Id
    @SequenceGenerator(name = "users_id", sequenceName = "users_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_car")
    private AdCar adCar_id;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private OrderRequestState state;

    private boolean usingTimeUp;
}

