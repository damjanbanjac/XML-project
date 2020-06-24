package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.JwtAuthenticationRequest;
import com.agent.agentapp.dto.request.UserRequest;
import com.agent.agentapp.dto.request.UserTokenState;
import com.agent.agentapp.dto.response.UserResponse;
import com.agent.agentapp.entity.Authority;
import com.agent.agentapp.entity.SimpleUser;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.security.TokenUtils;
import com.agent.agentapp.service.implementation.CustomUserDetailsService;
import com.agent.agentapp.service.implementation.SimpleUserService;
import com.agent.agentapp.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

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
    private SimpleUserService simpleUserService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException, IOException {

        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        SimpleUser user = (SimpleUser) authentication.getPrincipal();
        User subject = userService.findOne(user.getId());
        System.out.println(subject.getId());
        if (subject == null) {
            Collection<?> roles = user.getAuthorities();
            String jwt = tokenUtils.generateToken(user, (Authority) roles.iterator().next());
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
        } else  {
            Collection<?> roles = user.getAuthorities();
            String jwt = tokenUtils.generateToken(user, (Authority) roles.iterator().next());
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
        }
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) throws Exception {


        SimpleUser existUser = this.simpleUserService.findOne(userRequest.getEmail());
        if (existUser != null) {
            throw new Exception("Already exists");
        }

        System.out.println(userRequest.getCountry());


        userService.save(userRequest);

        UserResponse userResponse = new UserResponse();
        userResponse.setActive(userRequest.getActive());
        userResponse.setBlocked(userRequest.getBlocked());
        userResponse.setCountry(userRequest.getCountry());
        userResponse.setEmail(userRequest.getEmail());
        userResponse.setName(userRequest.getName());
        userResponse.setSurname(userRequest.getSurname());
        userResponse.setPhoneNumber(userRequest.getPhoneNumber());
        userResponse.setPermissionBlocked(userRequest.getPermissionBlocked());
        userResponse.setRate(userRequest.getRate());
        userResponse.setTown(userRequest.getTown());

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

}