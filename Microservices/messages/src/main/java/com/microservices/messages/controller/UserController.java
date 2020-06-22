package com.microservices.messages.controller;

import com.microservices.messages.dto.RequestDTO;
import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception {
        List<UserDTO> response = userService.getAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/user/loggedUser")
    public ResponseEntity<UserDTO> getUser(){
        long idUser = 1;
        UserDTO response = userService.getUser(idUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PostMapping(value = "/user/user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) throws Exception {

        UserDTO userdto = new UserDTO();
        userdto = userService.createUser(userDTO);
        return new ResponseEntity<>(userdto, HttpStatus.OK);
    }


}
