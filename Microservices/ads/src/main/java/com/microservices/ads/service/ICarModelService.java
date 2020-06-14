package com.microservices.ads.service;



import com.microservices.ads.dto.response.CarModelResponse;

import java.util.List;

public interface ICarModelService {

    CarModelResponse getCarModel(long id);

    List<CarModelResponse> getAllCarModels();



    void deleteCarModel(long id);
}
