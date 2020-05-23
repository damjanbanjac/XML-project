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
        return userRepository.findByEmail(mail);
    }

    public void save(UserRequest user) {

        User subject = new User();
        subject.setName(user.getName());
        subject.setEmail(user.getEmail());

        userRepository.save(subject);


    }

}
