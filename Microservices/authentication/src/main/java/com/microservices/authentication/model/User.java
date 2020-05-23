package com.microservices.authentication.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
@Table(name = "Users")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS)

public class User {
    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
    private String country;
    private String town;
    private Boolean active;
    private Boolean blocked;
    private Boolean permissionBlocked;
    private String rate;
    private String password;
}
