package com.microservices.authentication.config;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;

@Component
public class EmailConfig {

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public EmailConfig(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Async
    public void send(String to, String subject, String templateName, Context context) {
        String body = templateEngine.process(templateName, context);
        sendMail(to, subject, body, true);
    }

    private void sendMail(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, isHtml);
            javaMailSender.send(mail);

        } catch (Exception e) {

        }
    }

    @Async
    public void send1(String to, String subject, String templateName, Context context) {
        String body = templateEngine.process(templateName, context);
        sendMail1(to, subject, body, true);
    }

    private void sendMail1(String to, String subject, String text, Boolean isHtml) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText("Dogodio se pokusaj napada, obratite paznju");
            javaMailSender.send(mail);

        } catch (Exception e) {

        }
    }
}
