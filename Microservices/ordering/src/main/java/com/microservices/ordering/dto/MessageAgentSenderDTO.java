package com.microservices.ordering.dto;

import com.microservices.ordering.model.Message;
import com.microservices.ordering.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageAgentSenderDTO {

    private Long id;

    private AgentDTO2 sender_id;
    private String messageText;
    private UserDTO receiver_id;
    private Date date;
    private String chatId;


    public MessageAgentSenderDTO(Long idMessage, AgentDTO2 sender, String text, UserDTO receiver, Date dat) {
        this.id = idMessage;
        this.sender_id = sender;
        this.messageText = text;
        this.receiver_id = receiver;
        this.date = dat;
    }

//    public MessageAgentSenderDTO(Message message) {
//        this.id = message.getId();
//        this.sender_id.setId(message.getSender_id().getId());
//        this.sender_id.setEmail(message.getSender_id().getEmail());
//        this.sender_id.setName(message.getSender_id().getName());
//        this.messageText = message.getMessageText();
//        this.receiver_id.setId(message.getReceiver_id().getId());
//        this.receiver_id.setEmail(message.getReceiver_id().getEmail());
//        this.receiver_id.setName(message.getReceiver_id().getName());
//        this.date = message.getDate();
//        this.chatId = message.getChatId();
//    }
}
