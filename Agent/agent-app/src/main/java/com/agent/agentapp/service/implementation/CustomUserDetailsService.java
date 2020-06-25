package com.agent.agentapp.service.implementation;

import com.agent.agentapp.entity.SimpleUser;
import com.agent.agentapp.repository.SimpleUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    protected final Log LOGGER = LogFactory.getLog(getClass());

    @Autowired
    private SimpleUserRepository userRepository;



   /* @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(mail);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with mail '%s'.", mail));
        } else {
            return (UserDetails) user;
        }
    } */

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        SimpleUser user = userRepository.findByEmail(mail);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with mail '%s'.", mail));
        } else {
            return user;
        }
    }



}


