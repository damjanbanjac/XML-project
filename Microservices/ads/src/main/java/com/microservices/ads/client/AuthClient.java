package com.microservices.ads.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication")
public interface AuthClient {

    @GetMapping("/auth/{id}")
    long getUser(@PathVariable("id") long id);
}
