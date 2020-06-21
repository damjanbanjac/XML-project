package com.agent.agentapp.service;

import com.agent.agentapp.dto.request.CreateTypeOfFuelRequest;
import com.agent.agentapp.dto.request.UpdateTypeOfFuelRequest;
import com.agent.agentapp.dto.response.TypeOfFuelResponse;

import java.util.List;

public interface ITypeOfFuelService {

    TypeOfFuelResponse getTypeOfFuel(long id);

    List<TypeOfFuelResponse> getAllTypesOfFuel();

    TypeOfFuelResponse createTypeOfFuel(CreateTypeOfFuelRequest request);

    TypeOfFuelResponse updateTypeOfFuel(UpdateTypeOfFuelRequest request, long id);

    void deleteTypeOfFuel(long id);
}
