package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateCarClassRequest;
import com.microservices.maintenance.dto.request.UpdateCarClassRequest;
import com.microservices.maintenance.dto.response.CarClassResponse;

import java.util.List;

public interface ICarClassService {

    CarClassResponse getCarClass(long id);

    List<CarClassResponse> getAllCarClass();

    CarClassResponse createCarClass(CreateCarClassRequest request);

    CarClassResponse updateCarClass(UpdateCarClassRequest request, long id);

    void deleteCarClass(long id);
}
