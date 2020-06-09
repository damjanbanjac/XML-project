package com.agent.agentapp.dto.response;

import com.agent.agentapp.entity.AdCar;
import lombok.Data;

@Data
public class ImageResponse {
    private Long id;
    private String name;
    private String type;
    private byte[] pic;
    private AdCar adCar;
}
