package com.microservices.ads.service;


import com.microservices.ads.dto.request.CreateAdminRequest;
import com.microservices.ads.dto.request.DenyCommentRequest;
import com.microservices.ads.dto.request.UpdateAdminRequest;
import com.microservices.ads.dto.response.AdminResponse;
import com.microservices.ads.dto.response.CommentResponse;

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
}
