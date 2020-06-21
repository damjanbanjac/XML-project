package com.agent.agentapp.dto.request;

import com.agent.agentapp.entity.AdCar;
import lombok.Data;

@Data
public class ImageRequest {
    private String name;
    private String type;
    private byte[] pic;
    private AdCar adCar;
}
