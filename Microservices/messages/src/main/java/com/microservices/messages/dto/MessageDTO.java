package com.microservices.messages.dto;

import com.microservices.messages.model.Message;
import com.microservices.messages.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;

    private Person sender;
    private String messageText;
    private Person receiver;
    private Date date;

    public MessageDTO(Message message) {
        this.id = message.getId();
        this.sender = message.getSender();
        this.messageText = message.getMessageText();
        this.receiver = message.getReceiver();
        this.date = message.getDate();
    }
}
