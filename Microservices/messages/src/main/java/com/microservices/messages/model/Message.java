//package com.microservices.messages.model;
//
//import jdk.nashorn.internal.objects.annotations.Getter;
//import jdk.nashorn.internal.objects.annotations.Setter;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "MessageMessage")
//public class Message {
//
//    @Id
//    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
//    private Long id;
//    private Object sender;
//    private String messageText;
//    private Object receiver;
//}

package com.microservices.messages.model;

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
@Table(name = "MessageMessages")
public class Message {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Long id;
//    @Resource(name = "sender")
//    private transient Person sender;
//    @Resource(name = "receiver")
//    private transient Person receiver;W
    @OneToOne
    private User sender;

    @OneToOne
    private User receiver;

    private String messageText;

    private Date date;
}
