package com.microservices.authentication.service;

import com.microservices.authentication.dto.request.GetIdRequest;
import com.microservices.authentication.dto.response.RegistrationResponse;

import java.util.List;

public interface IAdminService {

    void approveRegistration(GetIdRequest request);

    void denyRegistration(GetIdRequest request);

    List<RegistrationResponse> getAllPendingRegistrations();
}