package com.microservices.authentication.service;

import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findOne(String mail) {
        return userRepository.findByMail(mail);
    }

    public void save(User user) {


        this.userRepository.save(user);


    }

}
