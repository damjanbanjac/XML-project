package com.microservices.authentication.controller;

import com.microservices.authentication.dto.request.AgentRequest;
import com.microservices.authentication.dto.request.GetIdRequest;
import com.microservices.authentication.dto.response.AgentResponse;
import com.microservices.authentication.dto.response.RegistrationResponse;
import com.microservices.authentication.service.IAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final IAdminService _adminService;

    public AdminController(IAdminService adminService) {
        _adminService = adminService;
    }

    @PostMapping("/register-agent")
    public AgentResponse registerAgent(@RequestBody AgentRequest request) {
        return _adminService.registerAgent(request);
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

    @GetMapping("/approved-registrations")
    public List<RegistrationResponse> getApprovedRegistrations() {
        return _adminService.getAllApprovedRegistrations();
    }

    @PostMapping("/block-user")
    public void blockUser(@RequestBody GetIdRequest request) {
        _adminService.blockUser(request);
    }
    
    @PostMapping("/unblock-user")
    public void unblockUser(@RequestBody GetIdRequest request) {
        _adminService.unblockUser(request);
    }
}
