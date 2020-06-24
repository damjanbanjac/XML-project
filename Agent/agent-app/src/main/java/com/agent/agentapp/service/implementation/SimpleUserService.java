package com.agent.agentapp.service.implementation;

import com.agent.agentapp.entity.SimpleUser;
import com.agent.agentapp.repository.SimpleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SimpleUserService {

    @Autowired
    private SimpleUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SimpleUser findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public SimpleUser findOne(String mail) {
        return userRepository.findByEmail(mail);
    }





}
