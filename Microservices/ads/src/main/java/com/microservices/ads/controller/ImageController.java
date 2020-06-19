package com.microservices.ads.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.microservices.ads.dto.response.ImageResponse;
import com.microservices.ads.model.Image;
import com.microservices.ads.repository.ImageRepository;
import com.microservices.ads.service.implementation.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@JsonSerialize
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;


    @PostMapping("/{idAd}/Ad")
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
    public void deleteImage(@PathVariable long id) throws Exception{
        imageService.deleteAdCar(id);
    }

    @GetMapping("/{id}/imageOne")
    public void GetImage(@PathVariable long id) throws Exception{

    }
}
