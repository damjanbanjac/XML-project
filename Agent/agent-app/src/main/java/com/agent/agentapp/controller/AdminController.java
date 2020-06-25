package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.ApproveCommentRequest;
import com.agent.agentapp.dto.request.DenyCommentRequest;
import com.agent.agentapp.dto.request.GetIdRequest;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.dto.response.RegistrationResponse;
import com.agent.agentapp.service.IAdminService;
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
    public void blockUser(@PathVariable Long id) {
        _adminService.blockUser(id);
    }

    @PutMapping("/unblock/{id}/user")
    public void unblockUser(@PathVariable Long id) {
        _adminService.unblockUser(id);
    }

    @PutMapping("/activate/{id}/user")
    public void activateUser(@PathVariable Long id) {
        _adminService.activateUser(id);
    }

    @PutMapping("/deactivate/{id}/user")
    public void deactivateUser(@PathVariable Long id) {
        _adminService.deactivateUser(id);
    }

    @PutMapping("/approve/{id}/comment")
    public CommentResponse approveComment(@PathVariable Long id) { return _adminService.approveComment(id); }

    @PutMapping("/deny/comment")
    public CommentResponse denyComment(@RequestBody DenyCommentRequest id) { return _adminService.denyComment(id); }

    @GetMapping("/pending-comments")
    public List<CommentResponse> getAllPendingComments(){
        return _adminService.getAllPendingComments();
    }

    @PostMapping("/approve-registration")
    public void approveRegistration(@RequestBody GetIdRequest request){
        _adminService.approveRegistration(request);
    }

    @PostMapping("/deny-registration")
    public void denyRegistration(@RequestBody GetIdRequest request){
        _adminService.denyRegistration(request);
    }

    @GetMapping("/pending-registrations")
    public List<RegistrationResponse> getPendingRegistrations(){
        return _adminService.getAllPendingRegistrations();
    }
}
