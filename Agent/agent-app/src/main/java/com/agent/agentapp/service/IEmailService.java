package com.agent.agentapp.service;

import com.agent.agentapp.entity.Agent;
import com.agent.agentapp.entity.User;

public interface IEmailService {

    void agentRegistrationMail(Agent agent);

    void customerRegistrationMail(User user);
}
