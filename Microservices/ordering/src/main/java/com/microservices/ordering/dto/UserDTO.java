package com.microservices.ordering.dto;

import com.microservices.ordering.model.Users;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String email;

    public UserDTO(Users user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}