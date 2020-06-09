package com.agent.agentapp.entity;

import com.agent.agentapp.dto.request.ImageRequest;
import com.agent.agentapp.dto.response.ImageResponse;
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
public class Image {

    @Id
    @SequenceGenerator(name = "image_id_seq", sequenceName = "image_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_seq")
    private Long id;
    private String name;
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
}
