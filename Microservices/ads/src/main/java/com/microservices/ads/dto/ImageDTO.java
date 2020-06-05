package com.microservices.ads.dto;

import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Image;
import lombok.Data;

@Data
public class ImageDTO {

    private String name;
    private String type;
    private byte[] pic;
    private AdCar adCar;

   /* public ImageDTO(Image image) {
        name = image.getName();
        type = image.getType();
        pic = image.getPic();
        adCar = image.getAdCar();
    } */
}
