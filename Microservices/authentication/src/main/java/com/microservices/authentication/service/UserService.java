package com.microservices.authentication.service;

import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.model.Authority;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.AuthorityRepository;
import com.microservices.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findOne(String mail) {
        return userRepository.findByEmail(mail);
    }

    public void save(UserRequest user) {

        Authority a  = new Authority();
        a.setName("USER");
        authorityRepository.save(a);
        User subject = new User();
        Authority auth = this.authorityRepository.findByName("USER");
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        subject.setName(user.getName());
        subject.setEmail(user.getEmail());
        //subject.setPhoneNumber(user.getPhoneNumber());
        subject.setSurname(user.getSurname());
        //subject.setCountry(subject.getCountry());
        //subject.setTown(subject.getTown());
        subject.setActive(true);
        subject.setBlocked(false);
        subject.setAuthorities(auths);
        subject.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(subject);


    }

}
