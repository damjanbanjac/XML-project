package com.microservices.ads.client;

import com.microservices.ads.dto.response.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;

@FeignClient(name = "ordering")
public interface OrderClient {

    @GetMapping("/orders/report/{id}")
     List<OrderDTO> getAllOrdersForReport(@PathVariable Long id) throws Exception;

    @GetMapping("/orders/{id}/customer")
    List<OrderDTO> getAllOrdersByCustomer(@PathVariable Long id) throws ParseException;

    @GetMapping("/orders/report/user/{id}")
    List<OrderDTO> getAllOrdersForReportUser(@PathVariable Long id) throws Exception;

    @DeleteMapping("orders/{id}/order")
    void deleteOrder(@PathVariable Long id);

}
