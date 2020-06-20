package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.MessageDTO;
import com.microservices.messages.model.Message;
import com.microservices.messages.model.User;
import com.microservices.messages.repository.IAgentRepository;
import com.microservices.messages.repository.IMessageRepository;
import com.microservices.messages.repository.IUserRepository;
import com.microservices.messages.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    private IAgentRepository agentRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {

        Message message = new Message();

        User sender = userRepository.findById(1);
        User receiver = userRepository.findById(2);

        message.setId((long)6);
        message.setSender(receiver);
        message.setReceiver(sender);
        message.setMessageText("Ovo je odgovor!");
        message.setDate(new Date());
        messageRepository.save(message);
        MessageDTO messagedto = new MessageDTO(message);
        return messagedto;
    }

}
