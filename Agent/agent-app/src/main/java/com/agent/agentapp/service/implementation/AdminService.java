package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.CreateAdminRequest;
import com.agent.agentapp.dto.request.DenyCommentRequest;
import com.agent.agentapp.dto.request.GetIdRequest;
import com.agent.agentapp.dto.request.UpdateAdminRequest;
import com.agent.agentapp.dto.response.AdminResponse;
import com.agent.agentapp.dto.response.CommentResponse;
import com.agent.agentapp.dto.response.RegistrationResponse;
import com.agent.agentapp.entity.Comment;
import com.agent.agentapp.entity.FirstLoginHelperEntity;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.repository.IAdminRepository;
import com.agent.agentapp.repository.ICommentRepository;
import com.agent.agentapp.repository.IFirtLoginHelperEntityRepository;
import com.agent.agentapp.repository.IUserRepository;
import com.agent.agentapp.service.IAdminService;
import com.agent.agentapp.service.IEmailService;
import com.agent.agentapp.utils.CommentRequestState;
import com.agent.agentapp.utils.RegistrationState;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final IUserRepository _userRepository;

    private final IAdminRepository _adminRepository;

    private final ICommentRepository _commentRepository;

    private IFirtLoginHelperEntityRepository _helperEntityRepository;

    private final IEmailService _emailService;

    public AdminService(IUserRepository userRepository, IAdminRepository adminRepository, ICommentRepository commentRepository, IFirtLoginHelperEntityRepository helperEntityRepository, IEmailService emailService) {
        _userRepository = userRepository;
        _adminRepository = adminRepository;
        _commentRepository = commentRepository;
        _helperEntityRepository = helperEntityRepository;
        _emailService = emailService;
    }

    @Override
    public AdminResponse getAdmin(long id) {
        return null;
    }

    @Override
    public List<AdminResponse> getAllAdmins() {
        return null;
    }

    @Override
    public AdminResponse createAdmin(CreateAdminRequest request) {
        return null;
    }

    @Override
    public AdminResponse updateAdmin(UpdateAdminRequest request, long id) {
        return null;
    }

    @Override
    public void deleteAdmin(long id) {

    }

    @Override
    public void blockUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setBlocked(true);
        _userRepository.save(user);
    }

    @Override
    public void unblockUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setBlocked(false);
        _userRepository.save(user);
    }

    @Override
    public void activateUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setActive(true);
        _userRepository.save(user);
    }

    @Override
    public void deactivateUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setActive(false);
        _userRepository.save(user);
    }

    @Override
    public List<CommentResponse> getAllPendingComments() {
        List<Comment> allComments = _commentRepository.findAll();
        List<Comment> pendingComments = new ArrayList<>();
        for(Comment c: allComments){
            if(c.getState().equals(CommentRequestState.PENDING)){
                pendingComments.add(c);
            }
        }
        List<CommentResponse> commentResponses = new ArrayList<>();
        for(Comment c: pendingComments){
            CommentResponse response = new CommentResponse();
            response.setCommId(c.getId());
            response.setComment(c.getComment());
            commentResponses.add(response);
        }
        return commentResponses;
    }

    @Override
    public CommentResponse approveComment(Long id) {
        Comment comment = _commentRepository.findOneById(id);
        comment.setState(CommentRequestState.APPROVED);
        _commentRepository.save(comment);
        CommentResponse response = new CommentResponse();
        response.setCommId(comment.getId());
        response.setComment(comment.getComment());
        return response;
    }

    @Override
    public CommentResponse denyComment(DenyCommentRequest request) {
        Comment comment = _commentRepository.findOneById(request.getId());
        comment.setState(CommentRequestState.DENIED);
        _commentRepository.save(comment);
        CommentResponse response = new CommentResponse();
        response.setCommId(comment.getId());
        response.setComment(comment.getComment());
        return response;
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

    @Override
    public List<RegistrationResponse> getAllApprovedRegistrations() {
        List<User> allUsers = _userRepository.findAll();
        List<User> approvedUsers = new ArrayList<>();
        for(User user: allUsers){
            if(user.getRegistrationState().equals(RegistrationState.APPROVED)){
                approvedUsers.add(user);
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
}
