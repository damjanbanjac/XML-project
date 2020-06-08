package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.CreateCarBrandRequest;
import com.agent.agentapp.dto.request.UpdateCarBrandRequest;
import com.agent.agentapp.dto.response.CarBrandResponse;

import java.util.List;

public interface ICarBrandService {

    CarBrandResponse getCarBrand(long id);

    List<CarBrandResponse> getAllCarBrands();

    CarBrandResponse createCarBrand(CreateCarBrandRequest request);

    CarBrandResponse updateCarBrand(UpdateCarBrandRequest request, long id);

    void deleteCarBrand(long id);
}
