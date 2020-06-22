package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.model.User;
import com.microservices.messages.repository.IUserRepository;
import com.microservices.messages.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private UserDTO mapToResponse(User user) {
        UserDTO response = new UserDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO)  {
        User user = new User();
        user.setId((long)3);
        user.setName("lala");
        user.setEmail("lala@gmail.com");
        userRepository.save(user);
        UserDTO userdto = new UserDTO(user);
        return userdto;
    }
}
