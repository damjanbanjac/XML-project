package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.feignDTOs.UsersDTO;

public interface IFeignService {

    UserDTO getUserDetails(Long id);

    UsersDTO getUser1Details(Long id);

    UserDTO changeUserDetails(Long id);

    UserDTO changeUserPermission(Long id);
}
