package com.microservices.ordering.service.implementation;

import com.microservices.ordering.dto.ChatDTO;
import com.microservices.ordering.dto.MessageDTO;
import com.microservices.ordering.dto.UserDTO;
import com.microservices.ordering.model.*;
import com.microservices.ordering.repository.*;
import com.microservices.ordering.service.IMessageService;
import com.microservices.ordering.dto.ChatDTO;
import com.microservices.ordering.dto.MessageDTO;
import com.microservices.ordering.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.ordering.model.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {

        Message message = new Message();


        Users sender = userRepository.findOneById(1);


        Users receiver = userRepository.findOneById(messageDTO.getReceiver().getId());


        if(sender == null || receiver == null) {
            return null;
        }

        String chat_id = sender.getEmail().concat(receiver.getEmail());
        Chat chat = chatRepository.findById(chat_id);
        if(chat == null) {
            chat_id = receiver.getEmail().concat(sender.getEmail());
        }
        chat = chatRepository.findById(chat_id);

        if(chat == null) {
            chat = new Chat(chat_id);
        }

        message.setSender(sender);
        message.setReceiver(receiver);
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


    public List<Long> getPendingRequestUsers() {
        long id_owner = 1;
        List<Request> requestList = requestRepository.findAll();
        List<Long> returnListOfId = new ArrayList<>();
        for(Request request : requestList) {
            if(request.getStatus().equals("PENDING")) {
                for(Order order : request.getOrderList()) {
                    if(order.getUserIzdavao().equals(id_owner)) {
                        for(Users user : userRepository.findAll()) {
                            if(order.getUserr().equals(user.getId())) {
                                returnListOfId.add(user.getId());
                            }
                        }
                    }
                }
            }
        }
        return returnListOfId;
    }

}
