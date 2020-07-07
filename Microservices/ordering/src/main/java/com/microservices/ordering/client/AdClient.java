package com.microservices.ordering.client;

import com.microservices.ordering.dto.AdCarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ads")
public interface AdClient {

    @GetMapping("/ads/{id}/ad")
    AdCarResponse getAd(@PathVariable("id") long id);
    
}
