package com.microservices.ads.dto.response;


import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Image;
import lombok.Data;

@Data
public class ImageResponse {
    private Long id;
    private String name;
    private String type;
    private byte[] pic;
    private AdCar adCar;

    public ImageResponse(Image img) {
        id = img.getId();
        name = img.getName();
        type = img.getType();
        pic = img.getPic();
    }

    public  ImageResponse() {

    }
}
