package com.microservices.ads.client;

import com.microservices.ads.dto.feignDTOs.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication")
//@FeignClient(name = "auth")
public interface AuthClient {

    @GetMapping("/auth/{id}")
    long getUser(@PathVariable("id") long id); //ovo nema poente, saljes id i ocekujes id? ili te interesuje neko drugo polje koje je tipa long

    @GetMapping("/feign/{id}/user")
    UserDTO getUserDetails(@PathVariable Long id);
}
