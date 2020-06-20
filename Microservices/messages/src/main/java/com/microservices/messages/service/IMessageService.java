package com.microservices.messages.service;

import com.microservices.messages.dto.MessageDTO;

public interface IMessageService {

    //List<MessageDTO> getAllMessages();

    MessageDTO createMessage(MessageDTO request);
}
