package com.microservices.ads.controller;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.service.AdsCarService;
import com.microservices.ads.service.IAdsCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads")
public class AdCarController {


    @Autowired
    private AdsCarService adsCarService;


    @PostMapping
    public AdCarResponse addAd(@RequestBody AdCarRequest request) throws Exception{
        return adsCarService.createAd(request);
    }

    @PutMapping("/{id}/ad")
    public AdCarResponse updateAd(@RequestBody AdCarRequest request, @PathVariable long id) throws Exception{
        return adsCarService.updateAd(request, id);
    }

    @DeleteMapping("/{id}/ad")
    public void deleteAd(@PathVariable long id) throws Exception{
        adsCarService.deleteAdCar(id);
    }

    @GetMapping("/{id}/ad")
    public void getAd(@PathVariable long id) throws Exception{
        adsCarService.getAd(id);
    }
    @GetMapping
    public List<AdCarResponse> getAllAds() throws Exception{
        return adsCarService.getAllAds();
    }
}
