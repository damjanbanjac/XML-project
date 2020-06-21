package com.microservices.ads.model;

import com.microservices.ads.utils.CommentRequestState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Comment {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;

    private String comment;

    @Enumerated(EnumType.STRING)
    private CommentRequestState state;

    private long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_car_id")
    private AdCar adCar;

    private boolean deleted;

    public Comment() {
        this.deleted = false;
        this.state = CommentRequestState.PENDING;
    }
}
