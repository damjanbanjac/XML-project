package com.microservices.messages.client;

import com.microservices.messages.dto.OrderDTO;
import com.microservices.messages.dto.RequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "order")
public interface MessagesClient {

//    @GetMapping("/requests/{idUser}/user")
//    List<RequestDTO> getUserRequests(@PathVariable Long idUser);
//
//    @GetMapping("/orders/{id}/user")
//    List<OrderDTO> getAllOrdersForUser(@PathVariable Long id);

}
