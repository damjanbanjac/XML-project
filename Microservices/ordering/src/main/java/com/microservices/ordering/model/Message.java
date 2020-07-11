package com.microservices.ordering.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Message")
public class Message {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
    //    @Resource(name = "sender")
//    private transient Person sender;
//    @Resource(name = "receiver")
//    private transient Person receiver;
//    @OneToOne
    private Long sender_id;

//    @OneToOne
    private Long receiver_id;

    private String messageText;

    private Date date;

    @Column(name = "chat_id")
    private String chatId;

}
