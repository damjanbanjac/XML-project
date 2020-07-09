package com.microservices.ordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChatOrder")
public class Chat {

    @Id
    @Column(name = "chat_id")
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id", referencedColumnName = "chat_id")
    private List<Message> messages;

    public Chat(String email) {
        this.id = email;
    }
}
