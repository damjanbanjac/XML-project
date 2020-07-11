package com.microservices.ordering.dto;

import com.microservices.ordering.client.AuthClient;
import com.microservices.ordering.model.Message;
import com.microservices.ordering.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    private Long sender_id;
    private String messageText;
    private Long receiver_id;
    private Date date;
    private String chatId;

//    public MessageDTO(Message message) {
//        this.id = message.getId();
////        this.sender_id.setId(authClient.getUser(message.getSender_id()).getId());
////        this.sender_id.setEmail(authClient.getUser(message.getSender_id()).getEmail());
////        this.sender_id.setName(authClient.getUser(message.getSender_id()).getName());
////        long idSender = message.getSender_id();
////        this.sender_id = authClient.getUser(idSender);
//        this.sender_id = message.getSender_id();
//        this.messageText = message.getMessageText();
//        this.receiver_id = message.getReceiver_id();
////        this.receiver_id = authClient.getUser(message.getReceiver_id());
////        this.receiver_id.setId(authClient.getUser(message.getReceiver_id()).getId());
////        this.receiver_id.setEmail(authClient.getUser(message.getReceiver_id()).getEmail());
////        this.receiver_id.setName(authClient.getUser(message.getReceiver_id()).getName());
//        this.date = message.getDate();
//        this.chatId = message.getChatId();
//    }
}
