package com.microservices.ads.service;


import com.microservices.ads.dto.request.TypeOfFuelRequest;
import com.microservices.ads.dto.response.TypeOfFuelResponse;

import java.util.List;

public interface ITypeOfFuelService {

    TypeOfFuelResponse getTypeOfFuel(long id);

    List<TypeOfFuelResponse> getAllTypesOfFuel();

    TypeOfFuelResponse createTypeOfFuel(TypeOfFuelRequest request);

    TypeOfFuelResponse updateTypeOfFuel(TypeOfFuelRequest request, long id);

    void deleteTypeOfFuel(long id);
}
