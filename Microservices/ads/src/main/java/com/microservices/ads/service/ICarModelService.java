package com.microservices.ads.service;

import com.microservices.ads.dto.request.CarModelRequest;
import com.microservices.ads.dto.response.CarModelResponse;

import java.util.List;

public interface ICarModelService {

    CarModelResponse getCarModel(long id);

    List<CarModelResponse> getAllCarModels();

    CarModelResponse createCarModel(CarModelRequest request);

    CarModelResponse updateCarModel(CarModelRequest request, long id);

    void deleteCarModel(long id);
}
