package com.microservices.authentication.controller;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.service.IFeignService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PutMapping("/{id}/user")
    public UserDTO changeUser(@PathVariable Long id){
        return _feignService.changeUserDetails(id);
    }

    @PutMapping("/permission/{id}/user")
    public UserDTO changeUserPermission(@PathVariable Long id){
        return _feignService.changeUserPermission(id);
    }
}
