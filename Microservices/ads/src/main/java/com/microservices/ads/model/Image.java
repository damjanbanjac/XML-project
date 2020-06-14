package com.microservices.ads.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservices.ads.dto.response.ImageResponse;
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
@Table(name = "Image")
public class Image {

    @Id
    @SequenceGenerator(name = "image_id_seq", sequenceName = "image_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_seq")
    private Long id;
    private String name;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private AdCar adCar;

    private String type;

    @Lob
    private byte[] pic;

    public Image(ImageResponse imageDTO) {
        name = imageDTO.getName();
        type = imageDTO.getType();
        pic = imageDTO.getPic();
        adCar = imageDTO.getAdCar();
    }

    public Image(String name, String type, byte[] pic) {
        this.name =name;
        this.type = type;
        this.pic = pic;
    }
}
