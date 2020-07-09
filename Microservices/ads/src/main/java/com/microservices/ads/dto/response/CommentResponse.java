package com.microservices.ads.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    private Long commId;

    private String comment;

    private String name;

    private String surname;

    private String email;
}
