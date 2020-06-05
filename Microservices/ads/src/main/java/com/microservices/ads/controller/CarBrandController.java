package com.microservices.ads.controller;

import com.microservices.ads.dto.CarBrandDTO;
import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.service.AdsCarService;
import com.microservices.ads.service.CarBrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brandsAd")
public class CarBrandController {

    @Autowired
    private CarBrandServices carBrandServices;

    @PostMapping
    public CarBrandDTO addBrand(@RequestBody CarBrandDTO request) throws Exception{
        return carBrandServices.createBrand(request);
    }
}
