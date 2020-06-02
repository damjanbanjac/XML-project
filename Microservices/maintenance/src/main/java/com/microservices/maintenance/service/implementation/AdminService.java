package com.microservices.maintenance.service.implementation;

import com.microservices.maintenance.dto.request.CreateAdminRequest;
import com.microservices.maintenance.dto.request.UpdateAdminRequest;
import com.microservices.maintenance.dto.response.AdminResponse;
import com.microservices.maintenance.entity.User;
import com.microservices.maintenance.repository.IAdminRepository;
import com.microservices.maintenance.repository.IUserRepository;
import com.microservices.maintenance.service.IAdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final IUserRepository _userRepository;

    private final IAdminRepository _adminRepository;

    public AdminService(IUserRepository userRepository, IAdminRepository adminRepository) {
        _userRepository = userRepository;
        _adminRepository = adminRepository;
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
}
