package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateAdminRequest;
import com.microservices.maintenance.dto.request.UpdateAdminRequest;
import com.microservices.maintenance.dto.response.AdminResponse;

import java.util.List;

public interface IAdminService {

    AdminResponse getAdmin(long id);

    List<AdminResponse> getAllAdmins();

    AdminResponse createAdmin(CreateAdminRequest request);

    AdminResponse updateAdmin(UpdateAdminRequest request, long id);

    void deleteAdmin(long id);

    void blockUser(long id);

    void unblockUser(long id);

    void activateUser(long id);

    void deactivateUser(long id);
}
