package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.response.ImageResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Image;
import com.agent.agentapp.repository.AdCarRepository;
import com.agent.agentapp.repository.ImageRepository;
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
