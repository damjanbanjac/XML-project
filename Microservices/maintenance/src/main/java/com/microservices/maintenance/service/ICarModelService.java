package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateCarModelRequest;
import com.microservices.maintenance.dto.request.UpdateCarModelRequest;
import com.microservices.maintenance.dto.response.CarModelResponse;

import java.util.Set;

public interface ICarModelService {

    CarModelResponse getCarModel(long id);

    Set<CarModelResponse> getAllCarModels();

    CarModelResponse createCarModel(CreateCarModelRequest request);

    CarModelResponse updateCarModel(UpdateCarModelRequest request, long id);

    void deleteCarModel(long id);
}
