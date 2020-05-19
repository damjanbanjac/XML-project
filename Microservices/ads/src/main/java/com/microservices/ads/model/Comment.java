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
public class Comment {

    @Id
    @SequenceGenerator(name = "comment_id_seq", sequenceName = "comment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
    private Long id;

    //na koji oglas se odnosi komentar
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private AdCar adCar;
    private String comment;
    // ko je komentarisao
    private Long userId;
    private  boolean accepted;
}
