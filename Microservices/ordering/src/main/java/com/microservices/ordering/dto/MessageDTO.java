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
public class MessageDTO {

    private Long id;

    private Users sender;
    private String messageText;
    private Users receiver;
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
