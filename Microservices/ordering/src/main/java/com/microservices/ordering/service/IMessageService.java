package com.microservices.ordering.service;

import com.microservices.ordering.dto.ChatDTO;
import com.microservices.ordering.dto.MessageDTO;

import java.util.List;

public interface IMessageService {

    //List<MessageDTO> getAllMessages();

    MessageDTO createMessage(MessageDTO request);

    public List<ChatDTO> getAllChats();

    ChatDTO getChat(String id);
}
