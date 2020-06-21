package com.microservices.search.service;

import com.microservices.search.dto.CarModelDTO;

import java.util.List;

public interface ICarModelService {

    CarModelDTO getCarModel(long id);

    List<CarModelDTO> getAllCarModels();

    CarModelDTO createCarModel(CarModelDTO carModelDTO);

    void deleteCarModel(long id);
}
