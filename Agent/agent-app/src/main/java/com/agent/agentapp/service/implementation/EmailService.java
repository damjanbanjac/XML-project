package com.agent.agentapp.service.implementation;

import com.agent.agentapp.config.EmailConfig;
import com.agent.agentapp.entity.Agent;
import com.agent.agentapp.entity.User;
import com.agent.agentapp.service.IEmailService;
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
