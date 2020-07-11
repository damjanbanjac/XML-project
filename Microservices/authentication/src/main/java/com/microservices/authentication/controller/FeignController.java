package com.microservices.authentication.controller;

import com.microservices.authentication.dto.feignDTOs.AgentDTO;
import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.feignDTOs.UsersDTO;
import com.microservices.authentication.service.AgentService;
import com.microservices.authentication.service.IFeignService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/feign")
public class FeignController {

    private final IFeignService _feignService;

    @Autowired
    private AgentService agentService;

    public FeignController(IFeignService feignService) {
        _feignService = feignService;
    }

    @GetMapping("/{id}/user")
    public UserDTO getUser(@PathVariable Long id){
        return _feignService.getUserDetails(id);
    }

    @GetMapping("/{id}/user1")
    public UsersDTO getUser1(@PathVariable Long id){
        return _feignService.getUser1Details(id);
    }

    @PutMapping("/{id}/user")
    public UserDTO changeUser(@PathVariable Long id){
        return _feignService.changeUserDetails(id);
    }

    @PutMapping("/permission/{id}/user")
    public UserDTO changeUserPermission(@PathVariable Long id){
        return _feignService.changeUserPermission(id);
    }

    @GetMapping("/{id}/agent")
    public AgentDTO getAgent(@PathVariable Long id){
        AgentDTO agentDTO = new AgentDTO("Null");
        agentDTO = agentService.getAgent(id);
        return agentDTO;
    }


    @GetMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgentDTO>> getAllAgents() throws Exception {
        List<AgentDTO> response = agentService.getAllAgents();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
