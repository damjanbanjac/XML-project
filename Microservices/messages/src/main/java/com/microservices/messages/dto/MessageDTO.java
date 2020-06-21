package com.microservices.messages.dto;

import com.microservices.messages.model.Message;
import com.microservices.messages.model.Person;
import com.microservices.messages.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    private User sender;
    private String messageText;
    private User receiver;
    private Date date;
    private String chatId;

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.sender = message.getSender();
        this.messageText = message.getMessageText();
        this.receiver = message.getReceiver();
        this.date = message.getDate();
        this.chatId = message.getChatId();
    }
}
