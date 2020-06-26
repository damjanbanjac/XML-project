package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.ApproveCommentRequest;
import com.agent.agentapp.dto.request.DenyCommentRequest;
import com.agent.agentapp.dto.request.GetIdRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.dto.response.RegistrationResponse;
import com.agent.agentapp.service.IAdminService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final IAdminService _adminService;

    public AdminController(IAdminService adminService) {
        _adminService = adminService;
    }

    @PutMapping("/block/{id}/user")
    // @PreAuthorize("hasAuthority('UN/BLOCK-USER')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void blockUser(@PathVariable Long id) {
        _adminService.blockUser(id);
    }

    @PutMapping("/unblock/{id}/user")
    // @PreAuthorize("hasAuthority('UN/BLOCK-USER')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void unblockUser(@PathVariable Long id) {
        _adminService.unblockUser(id);
    }

    @PutMapping("/activate/{id}/user")
    // @PreAuthorize("hasAuthority('DE/ACTIVATE-USER')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void activateUser(@PathVariable Long id) {
        _adminService.activateUser(id);
    }

    @PutMapping("/deactivate/{id}/user")
    // @PreAuthorize("hasAuthority('DE/ACTIVATE-USER')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void deactivateUser(@PathVariable Long id) {
        _adminService.deactivateUser(id);
    }

    @PutMapping("/approve/{id}/comment")
    // @PreAuthorize("hasAuthority('APPROVE/DENY-COMMENT')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public CommentResponse approveComment(@PathVariable Long id) { return _adminService.approveComment(id); }

    @PutMapping("/deny/comment")
    // @PreAuthorize("hasAuthority('APPROVE/DENY-COMMENT')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public CommentResponse denyComment(@RequestBody DenyCommentRequest id) { return _adminService.denyComment(id); }

    @GetMapping("/pending-comments")
    public List<CommentResponse> getAllPendingComments(){
        return _adminService.getAllPendingComments();
    }

    @PostMapping("/approve-registration")
    // @PreAuthorize("hasAuthority('APPROVE/DENY-REGISTRATION')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void approveRegistration(@RequestBody GetIdRequest request){
        _adminService.approveRegistration(request);
    }

    @PostMapping("/deny-registration")
    // @PreAuthorize("hasAuthority('APPROVE/DENY-REGISTRATION')")
     @PreAuthorize("hasAuthority('ADMIN')")
    public void denyRegistration(@RequestBody GetIdRequest request){
        _adminService.denyRegistration(request);
    }

    @GetMapping("/pending-registrations")
    public List<RegistrationResponse> getPendingRegistrations(){
        return _adminService.getAllPendingRegistrations();
    }

    @GetMapping("/approved-registrations")
    public List<RegistrationResponse> getApprovedRegistrations() {
        return _adminService.getAllApprovedRegistrations();
    }
}
