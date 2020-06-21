package com.microservices.ads.controller;

import com.microservices.ads.dto.request.DenyCommentRequest;
import com.microservices.ads.dto.response.CommentResponse;
import com.microservices.ads.service.IAdminService;
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

}
