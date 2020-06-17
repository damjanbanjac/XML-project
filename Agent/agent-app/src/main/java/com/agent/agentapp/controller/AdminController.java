package com.agent.agentapp.controller;

import com.agent.agentapp.service.IAdminService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void approveComment(@PathVariable Long id) { _adminService.approveComment(id); }

    @PutMapping("/deny/{id}/comment")
    public void denyComment(@PathVariable Long id) { _adminService.denyComment(id); }
}
