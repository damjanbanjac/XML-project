package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateAdminRequest;
import com.microservices.maintenance.dto.request.UpdateAdminRequest;
import com.microservices.maintenance.dto.response.AdminResponse;

import java.util.Set;

public interface IAdminService {

    AdminResponse getAdmin(long id);

    Set<AdminResponse> getAllAdmins();

    AdminResponse createAdmin(CreateAdminRequest request);

    AdminResponse updateAdmin(UpdateAdminRequest request, long id);

    void deleteAdmin(long id);
}
