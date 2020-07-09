package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.UserDTO;

public interface IFeignService {

    UserDTO getUserDetails(Long id);
}
