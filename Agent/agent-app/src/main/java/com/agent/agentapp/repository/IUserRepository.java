package com.agent.agentapp.repository;

import com.agent.agentapp.entity.User;
import com.agent.agentapp.utils.RegistrationState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);
}
