package com.microservices.ordering.controller;

import com.microservices.ordering.dto.OrderDTO;
import com.microservices.ordering.dto.RequestDTO;
import com.microservices.ordering.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/requests", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

    @Autowired
    private IRequestService irequestService;

    @PostMapping
    public RequestDTO createRequestForUser(@RequestBody RequestDTO request,@RequestBody OrderDTO order) {
        return irequestService.createRquestForUser(request, order);
    }

    @PostMapping("/personally")
    public RequestDTO presonallyRequest(@RequestBody OrderDTO order){
        return irequestService.presonallyRequest(order);
    }
}
