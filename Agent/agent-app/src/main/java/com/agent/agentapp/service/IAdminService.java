package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.*;
import com.agent.agentapp.dto.response.AdminResponse;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.dto.response.RegistrationResponse;

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

    List<CommentResponse> getAllPendingComments();

    CommentResponse approveComment(Long id);

    CommentResponse denyComment(DenyCommentRequest request);

    void approveRegistration(GetIdRequest request);

    void denyRegistration(GetIdRequest request);

    List<RegistrationResponse> getAllPendingRegistrations();
}
