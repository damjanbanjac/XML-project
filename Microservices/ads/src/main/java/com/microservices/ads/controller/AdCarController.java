package com.microservices.ads.controller;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.ImageResponse;
import com.microservices.ads.model.Image;
import com.microservices.ads.repository.ImageRepository;
import com.microservices.ads.service.implementation.AdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
