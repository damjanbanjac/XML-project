package com.microservices.authentication.controller;

import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;
import com.microservices.authentication.model.User;
import com.microservices.authentication.security.TokenUtils;
import com.microservices.authentication.service.CustomUserDetailsService;
import com.microservices.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;



    @Autowired
    private UserService userService;




    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) throws Exception {




        UserResponse userResponse = new UserResponse();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }


}