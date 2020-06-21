package com.microservices.ads.dto.request;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class ImageRequest {
    private String name;
    private String type;
    private byte[] pic;
    private AdCar adCar;
}
