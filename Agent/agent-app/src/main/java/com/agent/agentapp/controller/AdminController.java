package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.ApproveCommentRequest;
import com.agent.agentapp.dto.request.DenyCommentRequest;
import com.agent.agentapp.dto.response.CommentResponse;
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

    @PutMapping("/approve/comment")
    public void approveComment(@RequestBody ApproveCommentRequest id) { _adminService.approveComment(id); }

    @PutMapping("/deny/comment")
    public void denyComment(@RequestBody DenyCommentRequest id) { _adminService.denyComment(id); }


}
