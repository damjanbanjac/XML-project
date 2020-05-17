package com.microservices.maintenance.service;

import com.microservices.maintenance.dto.request.CreateTypeOfGearshiftRequest;
import com.microservices.maintenance.dto.request.UpdateTypeOfGearshiftRequest;
import com.microservices.maintenance.dto.response.TypeOfGearshiftResponse;

import java.util.Set;

public interface ITypeOfGearshiftService {

    TypeOfGearshiftResponse getTypeOfGearshift(long id);

    Set<TypeOfGearshiftResponse> getAllTypesOfGearshifts();

    TypeOfGearshiftResponse createTypeOfGearshift(CreateTypeOfGearshiftRequest request);

    TypeOfGearshiftResponse updateTypeOfGearshift(UpdateTypeOfGearshiftRequest request, long id);

    void deleteTypeOfGearshift(long id);
}
