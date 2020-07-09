package com.microservices.ordering.service;

import com.microservices.ordering.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO getUser(long id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO request);

//    UserDTO updateAd(UserDTO request, long id);

//    void deleteUser(long id);
}
