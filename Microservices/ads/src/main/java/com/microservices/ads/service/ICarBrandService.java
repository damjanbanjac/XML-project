package com.microservices.ads.service;

import com.microservices.ads.dto.request.CarBrandRequest;
import com.microservices.ads.dto.response.CarBrandResponse;

import java.util.List;

public interface ICarBrandService {

    CarBrandResponse getCarBrand(long id);

    List<CarBrandResponse> getAllCarBrands();

    CarBrandResponse createCarBrand(CarBrandRequest request);

    CarBrandResponse updateCarBrand(CarBrandRequest request, long id);

    void deleteCarBrand(long id);
}
