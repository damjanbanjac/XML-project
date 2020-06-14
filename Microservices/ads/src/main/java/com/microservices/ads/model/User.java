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
@Table(name = "UserAd")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)

public class User {
    @Id
    @SequenceGenerator(name = "users_id", sequenceName = "users_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id")
    private Long id;

    private String email;

    private Boolean blocked;

    private Boolean active;

}