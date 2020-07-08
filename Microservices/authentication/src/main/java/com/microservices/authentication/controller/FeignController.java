package com.microservices.authentication.controller;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.service.IFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    private final IFeignService _feignService;

    public FeignController(IFeignService feignService) {
        _feignService = feignService;
    }

    @GetMapping("/{id}/user")
    public UserDTO getUser(@PathVariable Long id){
        return _feignService.getUserDetails(id);
    }
}
