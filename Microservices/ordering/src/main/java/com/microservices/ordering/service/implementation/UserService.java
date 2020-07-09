package com.microservices.ordering.service.implementation;

import com.microservices.ordering.dto.ChatDTO;
import com.microservices.ordering.dto.UserDTO;
import com.microservices.ordering.model.Chat;
import com.microservices.ordering.model.Users;
import com.microservices.ordering.repository.UserRepository;
import com.microservices.ordering.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> userList = userRepository.findAll();
        return userList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private UserDTO mapToResponse(Users user) {
        UserDTO response = new UserDTO();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        return response;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO)  {
        Users user = new Users();
        user.setId((long)3);
        user.setName("lala");
        user.setEmail("lala@gmail.com");
        userRepository.save(user);
        UserDTO userdto = new UserDTO(user);
        return userdto;
    }

    @Override
    public UserDTO getUser(long id) {
        Users user = userRepository.findOneById(id);
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }
}
