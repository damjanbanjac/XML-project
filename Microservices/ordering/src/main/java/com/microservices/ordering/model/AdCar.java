package com.microservices.ordering.model;

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
@Table(name="AdCarOrder")
public class AdCar {

    @Id
    @SequenceGenerator(name = "adcar_id_seq", sequenceName = "adcar_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adcar_id_seq")
    private Long id;

    /*
    @OneToOne(fetch = FetchType.EAGER)
    public
    Order orders;*/

}
