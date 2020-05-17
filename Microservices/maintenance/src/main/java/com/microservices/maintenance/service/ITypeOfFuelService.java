package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateTypeOfFuelRequest;
import com.microservices.maintenance.dto.request.UpdateTypeOfFuelRequest;
import com.microservices.maintenance.dto.response.TypeOfFuelResponse;

import java.util.Set;

public interface ITypeOfFuelService {

    TypeOfFuelResponse getTypeOfFuel(long id);

    Set<TypeOfFuelResponse> getAllTypesOfFuel();

    TypeOfFuelResponse createTypeOfFuel(CreateTypeOfFuelRequest request);

    TypeOfFuelResponse updateTypeOfFuel(UpdateTypeOfFuelRequest request, long id);

    void deleteTypeOfFuel(long id);
}
