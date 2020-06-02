package com.microservices.ads.dto;

import lombok.Data;

@Data
public class ImageDTO {

    private String name;
    private String type;
    private byte[] pic;
}
