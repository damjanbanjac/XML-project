package com.microservices.ads.controller;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.request.PricelistRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.PricelistResponse;
import com.microservices.ads.service.implementation.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pricelist")
public class PricelistController {

    @Autowired
    PricelistService pricelistService;

    @PostMapping("/{id}/user")
    public PricelistResponse addPricelist(@RequestBody PricelistRequest request, @PathVariable long id) throws Exception{
        System.out.println("user id" + id);
        return pricelistService.createPricelistUser(request,id);
    }

    @PostMapping("/{id}/agent")
    public PricelistResponse addPricelistAgent(@RequestBody PricelistRequest request,@PathVariable long id) throws Exception{
        return pricelistService.createPricelistAgent(request,id);
    }

    @GetMapping("/{id}/user")
    public List<PricelistResponse> getAllPricelistFromUser(@PathVariable long id) throws Exception{
        return pricelistService.getAllPricelistUser(id);
    }

    @GetMapping("/{id}/ad")
    public PricelistResponse getPricelist(@PathVariable long id) throws Exception{
        return pricelistService.getPricelist(id);
    }

    @GetMapping("/{id}/agent")
    public List<PricelistResponse> getAllAdsFromAgent(@PathVariable long id) throws Exception{
        return pricelistService.getAllPricelistAgent(id);
    }
}
