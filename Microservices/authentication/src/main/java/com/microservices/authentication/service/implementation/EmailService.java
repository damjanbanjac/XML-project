package com.microservices.authentication.service.implementation;

import com.microservices.authentication.config.EmailConfig;
import com.microservices.authentication.model.Agent;
import com.microservices.authentication.model.User;
import com.microservices.authentication.service.IEmailService;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class EmailService implements IEmailService {

    private final EmailConfig _emailConfig;

    public EmailService(EmailConfig emailConfig) {
        _emailConfig = emailConfig;
    }

    @Override
    public void agentRegistrationMail(Agent agent) {
        String to = agent.getEmail();
        String subject = "Vaš zahtev za registraciju je odobren!";
        Context context = new Context();
        context.setVariable("name", String.format("%s", agent.getName()));
        _emailConfig.send(to, subject, "registrationMail", context);
    }

    @Override
    public void customerRegistrationMail(User user) {
        String to = user.getEmail();
        String subject = "Vaš zahtev za registraciju je odobren!";
        Context context = new Context();
        context.setVariable("name", String.format("%s %s", user.getName(), user.getSurname()));
        _emailConfig.send(to, subject, "registrationMail", context);
    }
}
