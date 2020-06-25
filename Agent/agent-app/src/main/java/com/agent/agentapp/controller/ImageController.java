package com.agent.agentapp.controller;

import com.agent.agentapp.dto.response.ImageResponse;
import com.agent.agentapp.entity.Image;
import com.agent.agentapp.repository.ImageRepository;
import com.agent.agentapp.service.implementation.ImageService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonSerialize
@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;


    @PostMapping("/{idAd}/Ad")
    // @PreAuthorize("hasAuthority('CRUD-IMAGE')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public ImageResponse addImage(@RequestParam("imageFile") MultipartFile imageFile, @PathVariable String idAd) throws Exception{
        //System.out.println(idAd);
        Long id  = Long.parseLong(idAd);
        return imageService.uploadImage(imageFile,id);
    }

     /*  @GetMapping("/{id}/AdCar")
       public List<ImageDTO> getAllPhotosByCar(@PathVariable Long id) throws Exception{
           return imageService.getAllPhotosByAdCar(id);
       }
   */
     @GetMapping("/{id}/image")
    public Image getImage(@PathVariable("id") String id) throws IOException {
         Long idCar  = Long.parseLong(id);
         Image retrievedImage = new Image();
         List<Image> allImages = imageRepository.findAll();

         for (Image image: allImages ) {
             if(image.getAdCar().getId() == idCar) {
                 retrievedImage = image;

                 break;
             }

         }
        Image img = new Image(retrievedImage.getName(), retrievedImage.getType(),
                retrievedImage.getPic());

        return img;

    }

    @DeleteMapping("/{id}/image")
    // @PreAuthorize("hasAuthority('CRUD-IMAGE')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public void deleteImage(@PathVariable long id) throws Exception{
        imageService.deleteAdCar(id);
    }

    @GetMapping("/{id}/imageOne")
    public void GetImage(@PathVariable long id) throws Exception{

    }
}
