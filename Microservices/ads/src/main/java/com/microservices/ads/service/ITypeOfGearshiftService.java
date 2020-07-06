package com.microservices.ads.service;

import com.microservices.ads.dto.request.TypeOfGearshiftRequest;
import com.microservices.ads.dto.response.TypeOfGearshiftResponse;

import java.util.List;

public interface ITypeOfGearshiftService {

    TypeOfGearshiftResponse getTypeOfGearshift(long id);

    List<TypeOfGearshiftResponse> getAllTypesOfGearshifts();

    TypeOfGearshiftResponse createTypeOfGearshift(TypeOfGearshiftRequest request);

    TypeOfGearshiftResponse updateTypeOfGearshift(TypeOfGearshiftRequest request, long id);

    void deleteTypeOfGearshift(long id);
}
