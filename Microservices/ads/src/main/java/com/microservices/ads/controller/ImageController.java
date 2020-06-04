package com.microservices.ads.controller;

import com.microservices.ads.dto.ImageDTO;
import com.microservices.ads.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/{idAdCar}/AdCar")
    public ImageDTO addImage(@RequestParam("imageFile") MultipartFile imageFile, @PathParam("idAdCar") Long idAdCar) throws Exception{
        return imageService.uploadImage(imageFile,idAdCar);
    }

    @GetMapping("/{id}/AdCar")
    public List<ImageDTO> getAllPhotosByCar(@PathVariable Long id) throws Exception{
        return imageService.getAllPhotosByAdCar(id);
    }

    @DeleteMapping("/{id}/image")
    public void deleteImage(@PathVariable long id) throws Exception{
        imageService.deleteAdCar(id);
    }
}
