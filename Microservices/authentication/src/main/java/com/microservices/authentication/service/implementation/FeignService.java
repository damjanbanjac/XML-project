package com.microservices.authentication.service.implementation;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.feignDTOs.UsersDTO;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.UserRepository;
import com.microservices.authentication.service.IFeignService;
import org.springframework.stereotype.Service;

@Service
public class FeignService implements IFeignService {

    private final UserRepository _userRepository;

    public FeignService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public UserDTO getUserDetails(Long id) {
        User user = _userRepository.findOneById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPermissionBlocked(user.getPermissionBlocked());

        return userDTO;
    }

    @Override
    public UsersDTO getUser1Details(Long id) {
        User user = _userRepository.findOneById(id);
        UsersDTO userDTO = new UsersDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPermissionBlocked(user.getPermissionBlocked());
        return userDTO;
    }



    @Override
    public UserDTO changeUserDetails(Long id) {
        User user = _userRepository.findOneById(id);
        user.setPermissionBlocked(true);
        _userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPermissionBlocked(user.getPermissionBlocked());
        return userDTO;
    }

    @Override
    public UserDTO changeUserPermission(Long id) {
        User user = _userRepository.findOneById(id);
        user.setPermissionBlocked(false);
        _userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPermissionBlocked(user.getPermissionBlocked());
        return userDTO;
    }
}
