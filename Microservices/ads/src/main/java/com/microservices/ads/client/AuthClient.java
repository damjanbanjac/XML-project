package com.microservices.ads.client;

import com.microservices.ads.dto.feignDTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "authentication")
//@FeignClient(name = "auth")
public interface AuthClient {

    @GetMapping("/auth/{id}")
    long getUser(@PathVariable("id") long id);

    @GetMapping("/feign/{id}/user")
    UserDTO getUserDetails(@PathVariable Long id);

    @PutMapping("/feign/{id}/user")
    UserDTO changeUserDetails(@PathVariable Long id);
}
