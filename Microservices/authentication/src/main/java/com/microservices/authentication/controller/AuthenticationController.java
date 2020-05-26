package com.microservices.authentication.controller;

import com.microservices.authentication.dto.request.JwtAuthenticationRequest;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.request.UserTokenState;
import com.microservices.authentication.dto.response.UserResponse;
import com.microservices.authentication.model.Authority;
import com.microservices.authentication.model.User;
import com.microservices.authentication.security.TokenUtils;
import com.microservices.authentication.service.CustomUserDetailsService;
import com.microservices.authentication.service.UserService;
import com.sun.deploy.nativesandbox.comm.Response;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
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

import javax.servlet.http.HttpServletResponse;
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
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException, IOException {

        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
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


    @PostMapping(value = "/register/{regType}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@PathVariable String regType, @RequestBody UserRequest userRequest) throws Exception {

        System.out.println(regType);

        if(regType.equals("password")) {
            userService.createLogFileFailure(regType,userRequest);
        }

        else if(regType.equals("phoneNumber")) {
            userService.createLogFileFailure(regType,userRequest);
        }

         else if(regType.equals("success")) {

            User existUser = this.userService.findOne(userRequest.getEmail());
            if (existUser != null) {
                throw new Exception("Alredy exist");
            }

            System.out.println(userRequest.getCountry());


            userService.save(userRequest);

            UserResponse userResponse = new UserResponse();
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
        }
            UserResponse userResponse = new UserResponse();
            HttpHeaders headers = new HttpHeaders();
            return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

//    @PostMapping(value = "/registerFailure/{broj}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> registerFailurePhoneNumber(@PathVariable String broj, @RequestBody UserRequest userRequest) throws Exception {
//        System.out.println(userRequest.getCountry());
//        userService.createLogFileFailurePhoneNumber(broj,userRequest);
//        UserResponse userResponse = new UserResponse();
//        HttpHeaders headers = new HttpHeaders();
//        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
//    }


}