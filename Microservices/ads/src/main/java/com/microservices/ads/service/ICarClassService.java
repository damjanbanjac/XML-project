package com.microservices.ads.service;

import com.microservices.ads.dto.request.CarClassRequest;
import com.microservices.ads.dto.response.CarClassResponse;

import java.util.List;

public interface ICarClassService {

    CarClassResponse getCarClass(long id);

    List<CarClassResponse> getAllCarClass();

    CarClassResponse createCarClass(CarClassRequest request);

    CarClassResponse updateCarClass(CarClassRequest request, long id);

    void deleteCarClass(long id);
}
