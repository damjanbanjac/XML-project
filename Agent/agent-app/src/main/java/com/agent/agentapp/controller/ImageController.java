package com.agent.agentapp.controller;

import com.agent.agentapp.dto.response.ImageResponse;
import com.agent.agentapp.service.implementation.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/{idAd}/Ad")
    public ImageResponse addImage(@RequestParam("imageFile") MultipartFile imageFile, @PathVariable String idAd) throws Exception{
        //System.out.println(idAd);
        Long id  = Long.parseLong(idAd);
        return imageService.uploadImage(imageFile,id);
    }

    /*   @GetMapping("/{id}/AdCar")
       public List<ImageDTO> getAllPhotosByCar(@PathVariable Long id) throws Exception{
           return imageService.getAllPhotosByAdCar(id);
       }
   */
    @DeleteMapping("/{id}/image")
    public void deleteImage(@PathVariable long id) throws Exception{
        imageService.deleteAdCar(id);
    }
}
