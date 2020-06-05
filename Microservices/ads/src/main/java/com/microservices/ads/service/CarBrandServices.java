package com.microservices.ads.service;

import com.microservices.ads.dto.CarBrandDTO;
import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.CarBrand;
import com.microservices.ads.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBrandServices {

    @Autowired
    CarBrandRepository carBrandRepository;

    public CarBrandDTO createBrand(CarBrandDTO request) {

        CarBrand carBrand = new CarBrand();
        carBrand.setName(request.getName());
        carBrandRepository.save(carBrand);
        CarBrandDTO carBrandDTO = new CarBrandDTO(carBrand);
        return  carBrandDTO;

    }

}
