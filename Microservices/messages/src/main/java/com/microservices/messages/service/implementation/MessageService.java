package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.ChatDTO;
import com.microservices.messages.dto.MessageDTO;
import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.model.Chat;
import com.microservices.messages.model.Message;
import com.microservices.messages.model.User;
import com.microservices.messages.repository.IAgentRepository;
import com.microservices.messages.repository.IChatRepository;
import com.microservices.messages.repository.IMessageRepository;
import com.microservices.messages.repository.IUserRepository;
import com.microservices.messages.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageRepository messageRepository;

    @Autowired
    private IAgentRepository agentRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IChatRepository chatRepository;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {

        Message message = new Message();

        User sender = userRepository.findById(1);

        User receiver = userRepository.findById((long)messageDTO.getReceiver().getId());

        String chat_id = sender.getEmail().concat(receiver.getEmail());
        Chat chat = chatRepository.findById(chat_id);
        if(chat == null) {
            chat_id = receiver.getEmail().concat(sender.getEmail());
        }
        chat = chatRepository.findById(chat_id);

        if(chat == null) {
            chat = new Chat(chat_id);
        }

        message.setSender(receiver);
        message.setReceiver(sender);
        message.setMessageText(messageDTO.getMessageText());
        message.setDate(new Date());
        messageRepository.save(message);

        List<Message> nova_lista = chat.getMessages();
        if(nova_lista == null) {
            nova_lista = new ArrayList<>();
        }
        nova_lista.add(message);
        chat.setMessages(nova_lista);
        chatRepository.save(chat);

        MessageDTO messagedto = new MessageDTO(message);
        return messagedto;
    }




    @Override
    public List<ChatDTO> getAllChats() {
        List<Chat> chatList = chatRepository.findAll();
        return chatList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private ChatDTO mapToResponse(Chat chat) {
        ChatDTO response = new ChatDTO();
        response.setId(chat.getId());
        response.setMessages(chat.getMessages());
        return response;
    }


    @Override
    public ChatDTO getChat(String id) {
        Chat chat = chatRepository.findById(id);
        ChatDTO chatDTO = new ChatDTO(chat);
        return chatDTO;
    }

}
