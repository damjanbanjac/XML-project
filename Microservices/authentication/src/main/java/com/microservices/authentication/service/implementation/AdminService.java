package com.microservices.authentication.service.implementation;

import com.microservices.authentication.dto.request.GetIdRequest;
import com.microservices.authentication.dto.response.RegistrationResponse;
import com.microservices.authentication.model.FirstLoginHelperEntity;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.IAdminRepository;
import com.microservices.authentication.repository.IFirstLoginHelperEntityRepository;
import com.microservices.authentication.repository.UserRepository;
import com.microservices.authentication.service.IAdminService;
import com.microservices.authentication.service.IEmailService;
import com.microservices.authentication.utils.RegistrationState;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final UserRepository _userRepository;

    private final IAdminRepository _adminRepository;

    private IFirstLoginHelperEntityRepository _helperEntityRepository;

    private final IEmailService _emailService;

    public AdminService(UserRepository userRepository, IAdminRepository adminRepository, IFirstLoginHelperEntityRepository helperEntityRepository, IEmailService emailService) {
        _userRepository = userRepository;
        _adminRepository = adminRepository;
        _helperEntityRepository = helperEntityRepository;
        _emailService = emailService;
    }

    @Override
    public void approveRegistration(GetIdRequest request) {
        User subject = _userRepository.findOneById(request.getId());
        subject.setRegistrationState(RegistrationState.APPROVED);
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
            responses.add(response);
        }
        return responses;
    }
}