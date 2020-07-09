package com.microservices.ads.dto.feignDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO { //for comments and grades

    private String name;

    private String surname;

    private String email;
}
