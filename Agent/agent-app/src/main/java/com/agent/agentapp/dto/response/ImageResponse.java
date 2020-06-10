package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Image;
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
