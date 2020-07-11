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
public class MessageAgentReceiverDTO {

    private Long id;
    private UserDTO sender_id;
    private String messageText;
    private AgentDTO2 receiver_id;
    private Date date;
    private String chatId;


    public MessageAgentReceiverDTO(Long idMessage, UserDTO sender, String text, AgentDTO2 receiver, Date dat) {
        this.id = idMessage;
        this.sender_id = sender;
        this.messageText = text;
        this.receiver_id = receiver;
        this.date = dat;
    }
}
