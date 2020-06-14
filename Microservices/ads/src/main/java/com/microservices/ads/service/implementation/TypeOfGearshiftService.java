package com.microservices.ads.service.implementation;


import com.microservices.ads.dto.response.TypeOfGearshiftResponse;
import com.microservices.ads.model.TypeOfGearshift;
import com.microservices.ads.repository.ITypeOfGearshiftRepository;
import com.microservices.ads.service.ITypeOfGearshiftService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOfGearshiftService implements ITypeOfGearshiftService {

    private final ITypeOfGearshiftRepository _typeOfGearshiftRepository;

    public TypeOfGearshiftService(ITypeOfGearshiftRepository typeOfGearshiftRepository) {
        _typeOfGearshiftRepository = typeOfGearshiftRepository;
    }

    @Override
    public TypeOfGearshiftResponse getTypeOfGearshift(long id) {
        TypeOfGearshift typeOfGearshift = _typeOfGearshiftRepository.findOneById(id);

        TypeOfGearshiftResponse typeOfGearshiftResponse = new TypeOfGearshiftResponse();
        typeOfGearshiftResponse.setId(typeOfGearshift.getId());
        typeOfGearshiftResponse.setType(typeOfGearshiftResponse.getType());

        return typeOfGearshiftResponse;
    }

    @Override
    public List<TypeOfGearshiftResponse> getAllTypesOfGearshifts() {
        List<TypeOfGearshift> typeOfGearshifts = _typeOfGearshiftRepository.findAllByDeleted(false);

        List<TypeOfGearshiftResponse> typeOfGearshiftResponses = new ArrayList<>();

        for(TypeOfGearshift typeOfGearshift: typeOfGearshifts) {
            TypeOfGearshiftResponse typeOfGearshiftResponse = new TypeOfGearshiftResponse();
            typeOfGearshiftResponse.setId(typeOfGearshift.getId());
            typeOfGearshiftResponse.setType(typeOfGearshift.getType());
            typeOfGearshiftResponses.add(typeOfGearshiftResponse);
        }

        return typeOfGearshiftResponses;
    }

 /*   @Override
    public TypeOfGearshiftResponse createTypeOfGearshift(CreateTypeOfGearshiftRequest request) {
        TypeOfGearshift typeOfGearshift = new TypeOfGearshift();
        typeOfGearshift.setType(request.getType());
        typeOfGearshift.setDeleted(false);

        _typeOfGearshiftRepository.save(typeOfGearshift);

        TypeOfGearshiftResponse typeOfGearshiftResponse = new TypeOfGearshiftResponse();
        typeOfGearshiftResponse.setId(typeOfGearshift.getId());
        typeOfGearshiftResponse.setType(typeOfGearshift.getType());

        return typeOfGearshiftResponse;
    }

    @Override
    public TypeOfGearshiftResponse updateTypeOfGearshift(UpdateTypeOfGearshiftRequest request, long id) {
        TypeOfGearshift typeOfGearshift = _typeOfGearshiftRepository.findOneById(id);
        typeOfGearshift.setType(request.getType());

        _typeOfGearshiftRepository.save(typeOfGearshift);

        TypeOfGearshiftResponse typeOfGearshiftResponse = new TypeOfGearshiftResponse();
        typeOfGearshiftResponse.setId(typeOfGearshift.getId());
        typeOfGearshiftResponse.setType(typeOfGearshift.getType());

        return typeOfGearshiftResponse;
    }
*/
    @Override
    public void deleteTypeOfGearshift(long id) {
        TypeOfGearshift typeOfGearshift = _typeOfGearshiftRepository.findOneById(id);
        typeOfGearshift.setDeleted(true);

        _typeOfGearshiftRepository.save(typeOfGearshift);
    }
}
