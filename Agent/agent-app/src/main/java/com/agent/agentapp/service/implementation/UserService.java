package com.agent.agentapp.service.implementation;

import ch.qos.logback.core.db.ConnectionSource;
import ch.qos.logback.core.db.DriverManagerConnectionSource;
import com.agent.agentapp.dto.request.UserRequest;
import com.agent.agentapp.entity.*;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.IAgentService;
import com.agent.agentapp.utils.RegistrationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private AgentRepository agentRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

  //  public User findOne(String mail) {
   //     return userRepository.findByEmail(mail);
 //   }

    public void saveAdmin(UserRequest user) throws SQLException {

        Admin subject = new Admin();
       // User subject = new User();
        Authority auth = this.authorityRepository.findByName("ADMIN");
        List<Authority> auths = new ArrayList<>();


        auths.add(auth);


        subject.setName(user.getName());
        subject.setEmail(user.getEmail());
        subject.setPhoneNumber(user.getPhoneNumber());
        subject.setSurname(user.getSurname());
        subject.setCountry(user.getCountry());
        subject.setTown(user.getTown());
        subject.setActive(true);
        subject.setBlocked(false);
        subject.setAuthorities(auths);
        subject.setPassword(passwordEncoder.encode(user.getPassword()));
       // createLogFileSuccess(user);
       // subject.setRegistrationState(RegistrationState.PENDING);
        adminRepository.save(subject);
    }

    public void save(UserRequest user) {
         User subject = new User();
        Authority auth = this.authorityRepository.findByName("USER");
        List<Authority> auths = new ArrayList<>();


        auths.add(auth);


        subject.setName(user.getName());
        subject.setEmail(user.getEmail());
        subject.setPhoneNumber(user.getPhoneNumber());
        subject.setSurname(user.getSurname());
        subject.setCountry(user.getCountry());
        subject.setTown(user.getTown());
        subject.setActive(true);
        subject.setBlocked(false);
        subject.setAuthorities(auths);
        subject.setPassword(passwordEncoder.encode(user.getPassword()));
        // createLogFileSuccess(user);
         subject.setRegistrationState(RegistrationState.PENDING);
         userRepository.save(subject);
    }

    public void saveAgent(UserRequest user) {
        Agent subject = new Agent();
        Authority auth = this.authorityRepository.findByName("AGENT");
        List<Authority> auths = new ArrayList<>();


        auths.add(auth);


        subject.setName(user.getName());
        subject.setEmail(user.getEmail());
        subject.setPhoneNumber(user.getPhoneNumber());
        subject.setSurname(user.getSurname());
        subject.setCountry(user.getCountry());
        subject.setTown(user.getTown());
        subject.setActive(true);
        subject.setBlocked(false);
        subject.setAuthorities(auths);
        subject.setPassword(passwordEncoder.encode(user.getPassword()));
        // createLogFileSuccess(user);
        //subject.setRegistrationState(RegistrationState.PENDING);
        agentRepository.save(subject);
    }

    public void createLogFileSuccess(UserRequest user) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("myLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("type: SUCCESS");
            logger.info("user" + user.getEmail());
            logger.info("messages: Register success by user");



        } catch (SecurityException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }



}