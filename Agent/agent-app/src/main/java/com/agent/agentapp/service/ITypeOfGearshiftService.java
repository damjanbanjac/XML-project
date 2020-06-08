package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.CreateTypeOfGearshiftRequest;
import com.agent.agentapp.dto.request.UpdateTypeOfGearshiftRequest;
import com.agent.agentapp.dto.response.TypeOfGearshiftResponse;

import java.util.List;

public interface ITypeOfGearshiftService {

    TypeOfGearshiftResponse getTypeOfGearshift(long id);

    List<TypeOfGearshiftResponse> getAllTypesOfGearshifts();

    TypeOfGearshiftResponse createTypeOfGearshift(CreateTypeOfGearshiftRequest request);

    TypeOfGearshiftResponse updateTypeOfGearshift(UpdateTypeOfGearshiftRequest request, long id);

    void deleteTypeOfGearshift(long id);
}
