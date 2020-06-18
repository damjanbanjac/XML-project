package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.AdCarRequest;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.dto.response.ImageResponse;
import com.agent.agentapp.entity.Image;
import com.agent.agentapp.repository.ImageRepository;
import com.agent.agentapp.service.implementation.AdCarService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/ads")
public class AdCarController {


    @Autowired
    private AdCarService adsCarService;

    @Autowired
    private ImageRepository imageRepository;




    @PostMapping
    public AdCarResponse addAd(@RequestBody AdCarRequest request) throws Exception{
        return adsCarService.createAd(request);
    }


    @PostMapping("/{id}/agent")
    public AdCarResponse addAdAgent(@RequestBody AdCarRequest request,@PathVariable long id) throws Exception{
        return adsCarService.createAdAgent(request,id);
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
    public AdCarResponse getAd(@PathVariable long id) throws Exception{
        return adsCarService.getAd(id);
    }
    @GetMapping
    public List<AdCarResponse> getAllAds() throws Exception{
        return adsCarService.getAllAds();
    }

    @GetMapping("/{id}/image")
    public List<ImageResponse> getImage(@PathVariable("id") String id) throws IOException {
        Long idCar  = Long.parseLong(id);
        Image retrievedImage = new Image();
        List<Image> allImages = imageRepository.findAll();
        List<ImageResponse> allResponse = new ArrayList<>();

        for (Image image: allImages ) {
            if(image.getAdCar().getId() == idCar) {
                System.out.println("usao");
                ImageResponse imageResponse = new ImageResponse(image);
                allResponse.add(imageResponse);


            }

        }

       // Image img = new Image(retrievedImage.getName(), retrievedImage.getType(),
             //   retrievedImage.getPic());
       // System.out.println(img.getAdCar());
       // System.out.println(img.getPic());
        //ImageResponse imageResponse = new ImageResponse(img);
        return allResponse;

    }
}
