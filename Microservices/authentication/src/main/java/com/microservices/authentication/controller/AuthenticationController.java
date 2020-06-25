package com.microservices.authentication.controller;

import com.microservices.authentication.dto.request.JwtAuthenticationRequest;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.request.UserTokenState;
import com.microservices.authentication.dto.response.UserResponse;
import com.microservices.authentication.model.Authority;
import com.microservices.authentication.model.FirstLoginHelperEntity;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.IFirstLoginHelperEntityRepository;
import com.microservices.authentication.security.TokenUtils;
import com.microservices.authentication.service.CustomUserDetailsService;
import com.microservices.authentication.service.UserService;
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
import java.time.LocalDateTime;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    private final IFirstLoginHelperEntityRepository helperEntityRepository;

    public AuthenticationController(IFirstLoginHelperEntityRepository repository) {
        this.helperEntityRepository = repository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException, IOException, Exception {

        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        User subject = userService.findOne(user.getId());
        System.out.println(subject.getId());

        boolean provera = false;
        Collection<?> roless = user.getAuthorities();
        Authority a = (Authority) roless.iterator().next();
        if(a.getName().equals("USER")) {
            provera =true;
        }

        if (provera == false) {
            Collection<?> roles = user.getAuthorities();
            String jwt = tokenUtils.generateToken(user, (Authority) roles.iterator().next());
            int expiresIn = tokenUtils.getExpiredIn();
            System.out.println("usao ovde");
            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
        }

        FirstLoginHelperEntity helperEntity = helperEntityRepository.findOneByEmail(subject.getEmail());
        if(helperEntity == null){
            throw new Exception("Bad credentials.");
        }
        if(!helperEntity.isAlreadyLogged()){
            LocalDateTime now = LocalDateTime.now();
            if(helperEntity.getRegistrationDateTime().plusHours(24L).isBefore(now)){
//            if(helperEntity.getRegistrationDateTime().plusMinutes(2L).isBefore(now)){
                throw new Exception("Your registration has been denied.");
            }
            helperEntity.setAlreadyLogged(true);
            helperEntityRepository.save(helperEntity);
        }
        if (subject == null) {
            System.out.println("usao i ovde");
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


        User existUser = this.userService.findOne(userRequest.getEmail());
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