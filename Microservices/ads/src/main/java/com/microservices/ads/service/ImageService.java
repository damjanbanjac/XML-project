package com.microservices.ads.service;

import com.microservices.ads.dto.ImageDTO;
import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.Image;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public ImageDTO uploadImage(MultipartFile request) throws IOException {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setName(request.getOriginalFilename());
        imageDTO.setPic(request.getBytes());
        imageDTO.setType(request.getContentType());
        Image img = new Image(imageDTO);
        imageRepository.save(img);
         return imageDTO;
    }
}
