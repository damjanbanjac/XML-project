package com.microservices.authentication.service;

import com.microservices.authentication.model.Agent;
import com.microservices.authentication.model.User;

public interface IEmailService {

    void agentRegistrationMail(Agent agent);

    void customerRegistrationMail(User user);
}
