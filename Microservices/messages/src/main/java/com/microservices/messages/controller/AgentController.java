package com.microservices.messages.controller;

import com.microservices.messages.dto.AgentDTO;
import com.microservices.messages.service.implementation.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping(value = "/agent/agents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AgentDTO>> getAllAgents() throws Exception {
        List<AgentDTO> response = agentService.getAllAgents();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/agent/agent")
    public ResponseEntity<AgentDTO> addAd(@RequestBody AgentDTO agentDTO) throws Exception {

        AgentDTO agentdto = new AgentDTO();
        agentdto = agentService.createAgent(agentDTO);
        return new ResponseEntity<>(agentdto, HttpStatus.OK);
    }


}
