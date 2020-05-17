package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateCarClassRequest;
import com.microservices.maintenance.dto.request.UpdateCarClassRequest;
import com.microservices.maintenance.dto.response.CarClassResponse;

import java.util.Set;

public interface ICarClassService {

    CarClassResponse getCarClass(long id);

    Set<CarClassResponse> getAllCarClass();

    CarClassResponse createCarClass(CreateCarClassRequest request);

    CarClassResponse updateCarClass(UpdateCarClassRequest request, long id);

    void deleteCarClass(long id);
}
