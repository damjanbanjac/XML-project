package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.JwtAuthenticationRequest;
import com.agent.agentapp.dto.request.UserRequest;
import com.agent.agentapp.dto.request.UserTokenState;
import com.agent.agentapp.dto.response.UserResponse;
import com.agent.agentapp.entity.Authority;
import com.agent.agentapp.entity.FirstLoginHelperEntity;
import com.agent.agentapp.entity.SimpleUser;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.repository.IFirtLoginHelperEntityRepository;
import com.agent.agentapp.security.TokenUtils;
import com.agent.agentapp.service.IEmailService;
import com.agent.agentapp.service.implementation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
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

    @Autowired
    private IFirtLoginHelperEntityRepository _helperEntityRepository;

    @Autowired
    private EmailService _emailService;

    private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final IFirtLoginHelperEntityRepository helperEntityRepository;

    public AuthenticationController(IFirtLoginHelperEntityRepository repository) {
        this.helperEntityRepository = repository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException, IOException, Exception {
//        logger.info("NE MOZE 2");
        System.out.println(authenticationRequest.getEmail() + " " + authenticationRequest.getPassword());
        System.out.println("provera 1");
        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));

        System.out.println("provera 2");

        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println("provera 3");

        SimpleUser user = (SimpleUser) authentication.getPrincipal();
        User subject = userService.findOne(user.getId());

        System.out.println("provera 4");


        if (subject == null) {
            Collection<?> roles = user.getAuthorities();
            String jwt = tokenUtils.generateToken(user, (Authority) roles.iterator().next());
            int expiresIn = tokenUtils.getExpiredIn();
            System.out.println("usao ovde");
            agentLoginSuccessfulLog(user.getEmail());
            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
        }


        FirstLoginHelperEntity helperEntity = helperEntityRepository.findOneByEmail(subject.getEmail());
        if(helperEntity == null){
            agentLoginFailureLog(authenticationRequest.getEmail());

            _emailService.customerRegistrationMail1();
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


        SimpleUser existUser = this.simpleUserService.findOne(userRequest.getEmail());
        if (existUser != null) {
            userRegistrationFailedLog(userRequest.getEmail());
            throw new Exception("Already exists");
        }

        System.out.println(userRequest.getCountry());
        userRegistrationSuccessfulLog(userRequest.getEmail());
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

    @PostMapping(value = "/register/agent")
    public ResponseEntity<?> addAgent(@RequestBody UserRequest userRequest) throws Exception {


        SimpleUser existUser = this.simpleUserService.findOne(userRequest.getEmail());
        if (existUser != null) {
            agentLoginFailureLog(userRequest.getEmail());
            throw new Exception("Already exists");
        }

        System.out.println(userRequest.getCountry());
        agentRegistrationSuccessfulLog(userRequest.getEmail());
        userService.saveAgent(userRequest);

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

    @PostMapping(value = "/register/admin")
    public ResponseEntity<?> addAdmin(@RequestBody UserRequest userRequest) throws Exception {


        SimpleUser existUser = this.simpleUserService.findOne(userRequest.getEmail());
        if (existUser != null) {
            adminRegistrationFailedLog(userRequest.getEmail());
            throw new Exception("Already exists");
        }

        System.out.println(userRequest.getCountry());
        adminRegistrationSuccessfulLog(userRequest.getEmail());
        userService.saveAdmin(userRequest);

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

    public void agentLoginSuccessfulLog(String email) {
        logger.info("SUCCESS Agent {} successfully logged.", email);
    }

    public void agentLoginFailureLog(String email) {
        logger.error("FAILURE Agent {} failed to login.", email);
    }


    public void userRegistrationSuccessfulLog(String email) {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS User {} successfully registered.", email);
//        }
    }

    public void agentRegistrationSuccessfulLog(String email) {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Agent {} successfully registered.", email);
//        }
    }

    public void adminRegistrationSuccessfulLog(String email) {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Admin {} successfully registered.", email);
//        }
    }

    public void userRegistrationFailedLog(String email) {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE User {} failed to register.", email);
//        }
    }

    public void agentRegistrationFailedLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE User failed to register.");
//        }
    }

    public void adminRegistrationFailedLog(String email) {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE User {} failed to register.", email);
//        }
    }

}