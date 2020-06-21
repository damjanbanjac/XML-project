package com.microservices.messages.service;

import com.microservices.messages.dto.ChatDTO;
import com.microservices.messages.dto.MessageDTO;

import java.util.List;

public interface IMessageService {

    //List<MessageDTO> getAllMessages();

    MessageDTO createMessage(MessageDTO request);

    public List<ChatDTO> getAllChats();

    ChatDTO getChat(String id);
}
