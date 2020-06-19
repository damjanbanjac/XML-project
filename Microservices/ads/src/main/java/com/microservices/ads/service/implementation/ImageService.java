package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.response.ImageResponse;
import com.microservices.ads.model.AdCar;
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

    @Autowired
    AdCarRepository adCarRepository;

    public ImageResponse uploadImage(MultipartFile request, Long idAd) throws IOException {
        System.out.println("prosledjen" + idAd);
        ImageResponse imageDTO = new ImageResponse();
        imageDTO.setName(request.getOriginalFilename());
        imageDTO.setPic(request.getBytes());
        imageDTO.setType(request.getContentType());
        AdCar adCar = adCarRepository.findOneById(idAd);
        System.out.println("trazeni" + adCar.getId());
        imageDTO.setAdCar(adCarRepository.findOneById(idAd));
        Image img = new Image(imageDTO);
        imageRepository.save(img);
        return imageDTO;
    }

   /* public List<ImageDTO> getAllPhotosByAdCar(Long id) {
        List<ImageDTO> imageDTOList = null;
        List<Image> imageList = imageRepository.findAll();
        for (Image image: imageList) {
            if(image.getAdCar().getId().equals(id)) {
                ImageDTO imageDTO = new ImageDTO(image);
                imageDTOList.add(imageDTO);
            }

        }
        return  imageDTOList;
    } */

    public void deleteAdCar(long id) {
        imageRepository.deleteById(id);
    }
}
