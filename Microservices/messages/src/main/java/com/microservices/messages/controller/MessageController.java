package com.microservices.messages.controller;

import com.microservices.messages.dto.MessageDTO;
import com.microservices.messages.service.implementation.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
//@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<MessageDTO>> getAllMessage() throws Exception {
//        List<MessageDTO> response = messageService.getAllMessages();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PostMapping(value = "/message/message")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) throws ParseException {

        MessageDTO messagedto = new MessageDTO();
        messagedto = messageService.createMessage(messageDTO);
        return new ResponseEntity<>(messagedto, HttpStatus.OK);
    }

}
