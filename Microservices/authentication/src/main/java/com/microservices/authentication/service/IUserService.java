package com.microservices.authentication.service;

import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;

import java.util.Set;

public interface IUserService {

    UserResponse getUser(long id);

    Set<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest request);

    UserResponse updateAd(UserRequest request, long id);

    void deleteUser(long id);
}
