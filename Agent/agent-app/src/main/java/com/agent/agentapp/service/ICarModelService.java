package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.CreateCarModelRequest;
import com.agent.agentapp.dto.request.UpdateCarModelRequest;
import com.agent.agentapp.dto.response.CarModelResponse;

import java.util.List;

public interface ICarModelService {

    CarModelResponse getCarModel(long id);

    List<CarModelResponse> getAllCarModels();

    CarModelResponse createCarModel(CreateCarModelRequest request);

    CarModelResponse updateCarModel(UpdateCarModelRequest request, long id);

    void deleteCarModel(long id);
}
