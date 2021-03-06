package com.microservices.authentication.service.implementation;

import com.microservices.authentication.dto.request.AgentRequest;
import com.microservices.authentication.dto.request.GetIdRequest;
import com.microservices.authentication.dto.response.AgentResponse;
import com.microservices.authentication.dto.response.RegistrationResponse;
import com.microservices.authentication.model.*;
import com.microservices.authentication.repository.*;
import com.microservices.authentication.service.IAdminService;
import com.microservices.authentication.service.IEmailService;
import com.microservices.authentication.utils.RegistrationState;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final UserRepository _userRepository;

    private final IAdminRepository _adminRepository;

    private IFirstLoginHelperEntityRepository _helperEntityRepository;

    private IAgentRepository _agentRepository;

    private AuthorityRepository authorityRepository;

    private final IEmailService _emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private final Logger logger = LoggerFactory.getLogger(AdminService.class);


    public AdminService(UserRepository userRepository, IAdminRepository adminRepository, IFirstLoginHelperEntityRepository helperEntityRepository, IAgentRepository agentRepository, IEmailService emailService, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        _userRepository = userRepository;
        _adminRepository = adminRepository;
        _helperEntityRepository = helperEntityRepository;
        _agentRepository = agentRepository;
        _emailService = emailService;

        this.authorityRepository = authorityRepository;
    }

    @Override
    public void approveRegistration(GetIdRequest request) {
        User subject = _userRepository.findOneById(request.getId());
        subject.setRegistrationState(RegistrationState.APPROVED);
        adminApprovedRegistrationLog();
        _userRepository.save(subject);
        FirstLoginHelperEntity helperEntity = new FirstLoginHelperEntity();
        helperEntity.setEmail(subject.getEmail());
        LocalDateTime now = LocalDateTime.now();
        helperEntity.setRegistrationDateTime(now);
        helperEntity.setAlreadyLogged(false);
        _helperEntityRepository.save(helperEntity);
        _emailService.customerRegistrationMail(subject);
    }

    @Override
    public void denyRegistration(GetIdRequest request) {
        User subject = _userRepository.findOneById(request.getId());
        subject.setRegistrationState(RegistrationState.DENIED);
        adminDeniedRegistrationLog();
        _userRepository.save(subject);
    }

    @Override
    public List<RegistrationResponse> getAllPendingRegistrations() {
        List<User> allUsers = _userRepository.findAll();
        List<User> pendingUsers = new ArrayList<>();
        for(User user: allUsers){
            if(user.getRegistrationState().equals(RegistrationState.PENDING)){
                pendingUsers.add(user);
            }
        }
        List<RegistrationResponse> responses = new ArrayList<>();
        for(User user: pendingUsers){
            RegistrationResponse response = new RegistrationResponse();
            response.setEmail(user.getEmail());
            response.setId(user.getId());
            response.setName(user.getName());
            response.setSurname(user.getSurname());
            response.setBlocked(user.getBlocked());
            response.setCountry(user.getCountry());
            response.setPhoneNumber(user.getPhoneNumber());
            response.setTown(user.getTown());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<RegistrationResponse> getAllApprovedRegistrations() {
        List<User> allUsers = _userRepository.findAll();
        List<User> approvedUsers = new ArrayList<>();

        List<Admin> allAdmins = _adminRepository.findAll();
        List<Agent> allAgents = _agentRepository.findAll();

        for(User user: allUsers){
            if(user.getRegistrationState().equals(RegistrationState.APPROVED)){
                if(!allAdmins.contains(_adminRepository.findOneById(user.getId()))
                && !allAgents.contains(_agentRepository.findOneById(user.getId()))){
                    approvedUsers.add(user);
                }
            }
        }
        List<RegistrationResponse> responses = new ArrayList<>();
        for(User user: approvedUsers){
            RegistrationResponse response = new RegistrationResponse();
            response.setEmail(user.getEmail());
            response.setId(user.getId());
            response.setName(user.getName());
            response.setSurname(user.getSurname());
            response.setBlocked(user.getBlocked());
            responses.add(response);
        }
        return responses;
    }

    public void adminApprovedRegistrationLog() {
//        if(logger.isErrorEnabled()) {
            logger.info("SUCCESS Agent successfully approved registration.");
//        }
    }

    public void adminDeniedRegistrationLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Agent successfully denied registration.");
        }

    @Override
    public AgentResponse registerAgent(AgentRequest request) {

        Agent agent = new Agent();

        Authority auth = this.authorityRepository.findByName("AGENT");
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        agent.setPib(request.getPib());
        agent.setName(request.getName());
        agent.setSurname(request.getSurname());
        agent.setEmail(request.getEmail());
        agent.setCountry(request.getCountry());
        agent.setPhoneNumber(request.getPhoneNumber());
        agent.setTown(request.getTown());
        agent.setRegistrationState(RegistrationState.APPROVED);
        agent.setBlocked(false);
        agent.setActive(true);
        agent.setPassword(passwordEncoder.encode(request.getPassword()));

        agent.setAuthorities(auths);
        _agentRepository.save(agent);

        AgentResponse agentResponse = new AgentResponse();
        agentResponse.setId(agent.getId());
        agentResponse.setPib(agent.getPib());
        agentResponse.setName(agent.getName());
        agentResponse.setSurname(agent.getSurname());
        agentResponse.setEmail(agent.getEmail());
        agentResponse.setCountry(agent.getCountry());
        agentResponse.setPhoneNumber(agent.getPhoneNumber());
        agentResponse.setTown(agent.getTown());

        return agentResponse;

    }

    @Override
    public void blockUser(GetIdRequest request) {
        User user = _userRepository.findOneById(request.getId());
        user.setBlocked(true);
        _userRepository.save(user);
    }

    @Override
    public void unblockUser(GetIdRequest request) {
        User user = _userRepository.findOneById(request.getId());
        user.setBlocked(false);
        _userRepository.save(user);
    }
}