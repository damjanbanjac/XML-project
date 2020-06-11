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

    @PostMapping("/{bundle}/request")
    public RequestDTO createRequestForUser(@PathVariable Boolean bundle,@RequestBody OrderDTO order) {
        return irequestService.createRquestForUser(bundle, order);
    }

    @PostMapping("/personally")
    public RequestDTO presonallyRequest(@RequestBody OrderDTO order){
        return irequestService.presonallyRequest(order);
    }
}
