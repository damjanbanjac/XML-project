package com.agent.agentapp.entity;

import com.agent.agentapp.utils.OrderRequestState;
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
@Table(name="OrderAd")
public class Order {

    @Id
    @SequenceGenerator(name = "users_id", sequenceName = "users_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id")
    private Long id;

    private Date availableFrom;
    private Date availableTo;
    private boolean required;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_car")
    private AdCar adCar_id;

    //koji agent je izdao oglas
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Agent agentIzdao;

    private boolean deleted;

    @Enumerated(EnumType.STRING)
    private OrderRequestState state;

    private boolean usingTimeUp;

    public boolean getRequired() {
        return required;
    }
}
