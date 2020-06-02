package com.microservices.ads.dto.response;

import com.microservices.ads.model.AdCar;
import lombok.Data;

@Data
public class CommentResponse {
    private AdCar adCar;
    private String comment;
    // ko je komentarisao
    private Long userId;
    private  boolean accepted;

}
