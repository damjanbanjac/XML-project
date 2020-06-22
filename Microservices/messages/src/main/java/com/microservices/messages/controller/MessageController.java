package com.microservices.messages.controller;

import com.microservices.messages.dto.ChatDTO;
import com.microservices.messages.dto.MessageDTO;
import com.microservices.messages.dto.RequestDTO;
import com.microservices.messages.dto.UserDTO;
import com.microservices.messages.service.implementation.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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

    @GetMapping(value = "/message/chats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChatDTO>> getAllChats() throws Exception {
        List<ChatDTO> response = messageService.getAllChats();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/message/chat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChatDTO> getChat(String id) throws Exception {
        ChatDTO chatDTO = messageService.getChat(id);
        return new ResponseEntity<>(chatDTO, HttpStatus.OK);
    }

//    @PostMapping(value = "/message/show/{idOwner}/{idRenter}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Long>> getPendingRequestsShow(@PathVariable Long idOwner, @PathVariable Long idRenter) throws ParseException {
//        List<Long> returnList = messageService.getPendingRequestUsers(idOwner,idRenter);
//        return new ResponseEntity<>(returnList, HttpStatus.OK);
//    }
        @GetMapping(value = "/message/show", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Long>> getPendingRequestsShow() throws ParseException {
        List<Long> returnList = messageService.getPendingRequestUsers();
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }
}
