package com.microservices.ads.dto.request;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class CommentRequest {

    private AdCar adCar;
    private String comment;
    // ko je komentarisao
    private Long userId;
    private  boolean accepted;

}
