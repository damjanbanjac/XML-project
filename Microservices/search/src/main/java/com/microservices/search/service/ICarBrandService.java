package com.microservices.search.service;

import com.microservices.search.dto.CarBrandDTO;

import java.util.List;

public interface ICarBrandService {

    CarBrandDTO createCarBrand(CarBrandDTO carBrandDTO);

    CarBrandDTO getCarBrand(long id);

    List<CarBrandDTO> getAllCarBrands();

    void deleteCarBrand(long id);
}
