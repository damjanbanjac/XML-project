package com.microservices.messages.controller;

import com.microservices.messages.dto.ChatDTO;
import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.dto.RequestDTO;
import com.microservices.messages.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

    @Autowired
    private IRequestService irequestService;

    @PostMapping("/{bundle}/request")
    public RequestDTO createRequestForUser(@PathVariable Boolean bundle,@RequestBody OrderDTO order) {
        return irequestService.createRquestForUser(bundle, order);
    }

    @PostMapping("/personally")
    public RequestDTO presonallyRequest(@RequestBody OrderDTO order){
        return irequestService.presonallyRequest(order);
    }

    @GetMapping("/{agentId}/agent")
    public List<RequestDTO> agentRequests(@PathVariable Long agentId){
        return irequestService.agentRequests(agentId);
    }

    @PostMapping("/{idRequest}/accept")
    public RequestDTO acceptRequest(@PathVariable Long idRequest){
        return irequestService.acceptRequest(idRequest);
    }

    @PostMapping("/{idRequest}/decline")
    public RequestDTO declineRequest(@PathVariable Long idRequest){
        return irequestService.declineRequest(idRequest);
    }

    @GetMapping("/{idUser}/user")
    public List<RequestDTO> userRequests(@PathVariable Long idUser){
        return irequestService.userRequests(idUser);
    }

    @PostMapping("/{idRequest}/paid")
    public RequestDTO paidRequest(@PathVariable Long idRequest){
        return irequestService.paidRequest(idRequest);
    }

    @GetMapping(value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestDTO>> getAllRequests() throws Exception {
        List<RequestDTO> response = irequestService.getAllRequests();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}