package com.microservices.ordering.dto;

import com.microservices.ordering.model.Chat;
import com.microservices.ordering.model.Message;
import com.microservices.ordering.model.Users;
import com.microservices.ordering.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.StyledEditorKit;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatDTO {
    private String id;
    private List<Message> messages;

    public ChatDTO(Chat chat) {
        this.id = chat.getId();
        this.messages = chat.getMessages();
    }
}