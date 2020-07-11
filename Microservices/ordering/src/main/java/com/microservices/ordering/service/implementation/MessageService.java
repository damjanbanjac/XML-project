package com.microservices.ordering.service.implementation;

import com.microservices.ordering.client.AuthClient;
import com.microservices.ordering.dto.*;
import com.microservices.ordering.model.*;
import com.microservices.ordering.repository.*;
import com.microservices.ordering.service.IMessageService;
import com.microservices.ordering.dto.ChatDTO;
import com.microservices.ordering.dto.MessageDTO;
import com.microservices.ordering.model.*;
import org.apache.catalina.User;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
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

    @Autowired
    private AuthClient authClient;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO, Long id) {

        Message message = new Message();

        List<AgentDTO2> agents = authClient.getAgents();
        AgentDTO2 receiverAgent = new AgentDTO2();
        for(AgentDTO2 agentDTO2 : agents) {
            if(messageDTO.getReceiver_id().equals(agentDTO2.getId())) {
                receiverAgent = agentDTO2;
            }
        }

        UserDTO senderDTO = authClient.getUser(id);
        senderDTO.setId(id);
//        Users sender = new Users(senderDTO);

        if(receiverAgent.getId() == null) {

            UserDTO receiverDTO = authClient.getUser(messageDTO.getReceiver_id());
            receiverDTO.setId(messageDTO.getReceiver_id());


//        Users receiver = new Users(receiverDTO);

            if (senderDTO == null || receiverDTO == null) {
                return null;
            }

            String chat_id = senderDTO.getEmail().concat(receiverDTO.getEmail());
            Chat chat = chatRepository.findById(chat_id);
            if (chat == null) {
                chat_id = receiverDTO.getEmail().concat(senderDTO.getEmail());
            }
            chat = chatRepository.findById(chat_id);

            if (chat == null) {
                chat = new Chat(chat_id);
            }

            message.setSender_id(senderDTO.getId());
            message.setReceiver_id(receiverDTO.getId());
            message.setMessageText(messageDTO.getMessageText());
            message.setDate(new Date());
            messageRepository.save(message);

            List<Message> nova_lista = chat.getMessages();
            if (nova_lista == null) {
                nova_lista = new ArrayList<>();
            }
            nova_lista.add(message);
            chat.setMessages(nova_lista);
            chatRepository.save(chat);

            MessageDTO messagedto = new MessageDTO();
            messagedto.setId(message.getId());
            messagedto.setSender_id(senderDTO.getId());
            messagedto.setReceiver_id(receiverDTO.getId());
            messagedto.setDate(message.getDate());
            messagedto.setMessageText(message.getMessageText());
            return messagedto;
        } else {


            if (senderDTO == null || receiverAgent == null) {
                return null;
            }

            String chat_id = senderDTO.getEmail().concat(receiverAgent.getEmail());
            Chat chat = chatRepository.findById(chat_id);
            if (chat == null) {
                chat_id = receiverAgent.getEmail().concat(senderDTO.getEmail());
            }
            chat = chatRepository.findById(chat_id);

            if (chat == null) {
                chat = new Chat(chat_id);
            }

            message.setSender_id(senderDTO.getId());
            message.setReceiver_id(receiverAgent.getId());
            message.setMessageText(messageDTO.getMessageText());
            message.setDate(new Date());
            messageRepository.save(message);

            List<Message> nova_lista = chat.getMessages();
            if (nova_lista == null) {
                nova_lista = new ArrayList<>();
            }
            nova_lista.add(message);
            chat.setMessages(nova_lista);
            chatRepository.save(chat);

            MessageDTO messagedto = new MessageDTO();
            messagedto.setId(message.getId());
            messagedto.setSender_id(senderDTO.getId());
            messagedto.setReceiver_id(receiverAgent.getId());
            messagedto.setDate(message.getDate());
            messagedto.setMessageText(message.getMessageText());
            return messagedto;
        }



    }



    @Override
    public MessageAgentSenderDTO createMessageAgentSender(MessageAgentSenderDTO messageDTO, Long id) {

        Message message = new Message();

//        List<AgentDTO2> agents = authClient.getAgents();
//        AgentDTO2 senderAgent = new AgentDTO2();
//        for(AgentDTO2 agentDTO2 : agents) {
//            if(id.equals(agentDTO2.getId())) {
//                senderAgent = agentDTO2;
//            }
//        }

        AgentDTO2 senderDTO = authClient.getAgent(id);
//        senderDTO.setId(id);
        UserDTO receiverDTO = authClient.getUser(messageDTO.getReceiver_id().getId());
        receiverDTO.setId(messageDTO.getReceiver_id().getId());

        if(senderDTO == null || receiverDTO == null) {
            return null;
        }

        String chat_id = senderDTO.getEmail().concat(receiverDTO.getEmail());
        Chat chat = chatRepository.findById(chat_id);
        if(chat == null) {
            chat_id = receiverDTO.getEmail().concat(senderDTO.getEmail());
        }
        chat = chatRepository.findById(chat_id);

        if(chat == null) {
            chat = new Chat(chat_id);
        }

        message.setSender_id(senderDTO.getId());
        message.setReceiver_id(receiverDTO.getId());
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

        MessageAgentSenderDTO messageAgentSenderDTO = new MessageAgentSenderDTO(message.getId(),authClient.getAgent(message.getSender_id()),message.getMessageText(),authClient.getUser(message.getSender_id()),message.getDate());
        return messageAgentSenderDTO;
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


    public List<Long> getPendingRequestUsers(Long id_owner) {
        List<Request> requestList = requestRepository.findAll();
        List<Long> returnListOfId = new ArrayList<>();
        for(Request request : requestList) {
            if(request.getStatus().equals("PENDING")) {
                for(Order order : request.getOrderList()) {
                    if(order.getUserIzdavao() != null) {
                        if (order.getUserIzdavao().equals(id_owner) || order.getUserr().equals(id_owner)) {
                            for (UserDTO user : authClient.getAllUsers()) {
                                if (order.getUserr().equals(user.getId()) || order.getUserIzdavao().equals(user.getId())) {
                                    if (!returnListOfId.contains(user.getId())) {
                                        returnListOfId.add(user.getId());
                                    }
                                }
                            }
                        }
                    }
                    if(order.getAgentIzdao() != null) {
                        if (order.getAgentIzdao().equals(id_owner) || order.getUserr().equals(id_owner)) {
                            for (UserDTO user : authClient.getAllUsers()) {
                                if (order.getUserr().equals(user.getId()) || order.getAgentIzdao().equals(user.getId())) {
                                    if(!returnListOfId.contains(user.getId())) {
                                        returnListOfId.add(user.getId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnListOfId;
    }

}
