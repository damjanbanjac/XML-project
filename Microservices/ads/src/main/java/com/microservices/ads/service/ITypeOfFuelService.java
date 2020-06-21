package com.microservices.ads.service;


import com.microservices.ads.dto.response.TypeOfFuelResponse;

import java.util.List;

public interface ITypeOfFuelService {

    TypeOfFuelResponse getTypeOfFuel(long id);

    List<TypeOfFuelResponse> getAllTypesOfFuel();


    void deleteTypeOfFuel(long id);
}
