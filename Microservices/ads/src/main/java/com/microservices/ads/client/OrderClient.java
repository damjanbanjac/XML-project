package com.microservices.ads.client;

import com.microservices.ads.dto.response.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ordering")
public interface OrderClient {

    @GetMapping("/orders/report")
     List<OrderDTO> getAllOrdersForReport() throws Exception;

}
