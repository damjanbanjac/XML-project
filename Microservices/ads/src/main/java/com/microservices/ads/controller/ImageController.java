package com.microservices.ads.controller;

import com.microservices.ads.dto.ImageDTO;
import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.service.AdsCarService;
import com.microservices.ads.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping
    public ImageDTO addImage(@RequestParam("imageFile") MultipartFile imageFile) throws Exception{
        return imageService.uploadImage(imageFile);
    }
}
