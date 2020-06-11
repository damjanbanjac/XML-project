package com.microservices.ads.service;




import com.microservices.ads.dto.response.TypeOfGearshiftResponse;

import java.util.List;

public interface ITypeOfGearshiftService {

    TypeOfGearshiftResponse getTypeOfGearshift(long id);

    List<TypeOfGearshiftResponse> getAllTypesOfGearshifts();



    void deleteTypeOfGearshift(long id);
}
