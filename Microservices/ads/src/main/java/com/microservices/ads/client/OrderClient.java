package com.microservices.ads.client;

import com.microservices.ads.dto.response.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;

@FeignClient(name = "ordering")
public interface OrderClient {

    @GetMapping("/orders/report")
     List<OrderDTO> getAllOrdersForReport() throws Exception;

    @GetMapping("/orders/{id}/customer")
    List<OrderDTO> getAllOrdersByCustomer(@PathVariable Long id) throws ParseException;

}
