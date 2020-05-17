package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateCarBrandRequest;
import com.microservices.maintenance.dto.request.UpdateCarBrandRequest;
import com.microservices.maintenance.dto.response.CarBrandResponse;

import java.util.Set;

public interface ICarBrandService {

    CarBrandResponse getCarBrand(long id);

    Set<CarBrandResponse> getAllCarBrands();

    CarBrandResponse createCarBrand(CreateCarBrandRequest request);

    CarBrandResponse updateCarBrand(UpdateCarBrandRequest request, long id);

    void deleteCarBrand(long id);
}
