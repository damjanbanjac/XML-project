package com.microservices.messages.service;

import com.microservices.messages.dto.UserDTO;

import java.util.List;

public interface IUserService {

//    UserDTO getUser(long id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO request);

//    UserDTO updateAd(UserDTO request, long id);

//    void deleteUser(long id);
}
