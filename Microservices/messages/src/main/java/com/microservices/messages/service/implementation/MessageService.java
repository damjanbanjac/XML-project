package com.microservices.messages.service.implementation;

import com.microservices.messages.dto.ChatDTO;
import com.microservices.messages.dto.MessageDTO;
import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.model.*;
import com.microservices.messages.repository.*;
import com.microservices.messages.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @Autowired
    private RequestRepository requestRepository;

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);


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

        sendMessageSuccessfulLog(sender.getEmail(),receiver.getEmail());

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
                    if(order.getUserIzdavao().getId().equals(id_owner)) {
                        for(User user : userRepository.findAll()) {
                            if(order.getUserr().getId().equals(user.getId())) {
                                returnListOfId.add(user.getId());
                            }
                        }
                    }
                }
            }
        }
        return returnListOfId;
    }


    public void sendMessageSuccessfulLog(String sender, String receiver) {
//        if(logger.isErrorEnabled()) {
        logger.info("User {} successfully sent a message to user {}", sender, receiver);
//        }
    }

}
