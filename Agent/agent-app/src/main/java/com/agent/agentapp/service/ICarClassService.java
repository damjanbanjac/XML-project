package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.CreateCarClassRequest;
import com.agent.agentapp.dto.request.UpdateCarClassRequest;
import com.agent.agentapp.dto.response.CarClassResponse;

import java.util.List;

public interface ICarClassService {

    CarClassResponse getCarClass(long id);

    List<CarClassResponse> getAllCarClass();

    CarClassResponse createCarClass(CreateCarClassRequest request);

    CarClassResponse updateCarClass(UpdateCarClassRequest request, long id);

    void deleteCarClass(long id);
}
