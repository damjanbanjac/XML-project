package com.microservices.search.service;

import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.dto.CarClassDTO;

import java.util.List;

public interface ICarClassService {

    CarClassDTO createCarClass(CarClassDTO carClassDTO);

    CarClassDTO getCarClass(long id);

    List<CarClassDTO> getAllCarClass();

    void deleteCarClass(long id);
}