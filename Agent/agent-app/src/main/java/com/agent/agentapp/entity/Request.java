package com.agent.agentapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Requests")
public class Request {

    @Id
    @SequenceGenerator(name = "request_id_seq", sequenceName = "request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_id_seq")
    private Long id;

    private String status;
    private Boolean bundle;

    private Date paymentDate;
    private Date acceptDate;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, mappedBy = "request")
    private List<Order> orderList = new ArrayList<>();
}
