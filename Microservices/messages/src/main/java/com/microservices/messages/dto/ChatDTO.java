package com.microservices.messages.dto;

import com.microservices.messages.model.Chat;
import com.microservices.messages.model.Message;
import com.microservices.messages.model.User;
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