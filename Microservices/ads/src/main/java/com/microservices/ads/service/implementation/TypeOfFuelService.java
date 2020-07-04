package com.microservices.ads.service.implementation;


import com.microservices.ads.dto.request.TypeOfFuelRequest;
import com.microservices.ads.dto.response.TypeOfFuelResponse;
import com.microservices.ads.model.TypeOfFuel;
import com.microservices.ads.repository.ITypeOfFuelRepository;
import com.microservices.ads.service.ITypeOfFuelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOfFuelService implements ITypeOfFuelService {

    private final ITypeOfFuelRepository _typeOfFuelRepository;

    public TypeOfFuelService(ITypeOfFuelRepository typeOfFuelRepository) {
        _typeOfFuelRepository = typeOfFuelRepository;
    }

    @Override
    public TypeOfFuelResponse getTypeOfFuel(long id) {
        TypeOfFuel typeOfFuel = _typeOfFuelRepository.findOneById(id);

        TypeOfFuelResponse typeOfFuelResponse = new TypeOfFuelResponse();
        typeOfFuelResponse.setId(typeOfFuel.getId());
        typeOfFuelResponse.setType(typeOfFuel.getType());

        return typeOfFuelResponse;
    }

    @Override
    public List<TypeOfFuelResponse> getAllTypesOfFuel() {
        List<TypeOfFuel> typeOfFuels = _typeOfFuelRepository.findAllByDeleted(false);

        List<TypeOfFuelResponse> typeOfFuelResponses = new ArrayList<>();

        for(TypeOfFuel typeOfFuel: typeOfFuels) {
            TypeOfFuelResponse typeOfFuelResponse = new TypeOfFuelResponse();
            typeOfFuelResponse.setType(typeOfFuel.getType());
            typeOfFuelResponse.setId(typeOfFuel.getId());
            typeOfFuelResponses.add(typeOfFuelResponse);
        }

        return typeOfFuelResponses;
    }

    @Override
    public TypeOfFuelResponse createTypeOfFuel(TypeOfFuelRequest request) {
        TypeOfFuel typeOfFuel = new TypeOfFuel();
        typeOfFuel.setType(request.getType());
        typeOfFuel.setDeleted(false);

        _typeOfFuelRepository.save(typeOfFuel);

        TypeOfFuelResponse typeOfFuelResponse = new TypeOfFuelResponse();
        typeOfFuelResponse.setId(typeOfFuel.getId());
        typeOfFuelResponse.setType(typeOfFuel.getType());

        return typeOfFuelResponse;
    }

    @Override
    public TypeOfFuelResponse updateTypeOfFuel(TypeOfFuelRequest request, long id) {
        TypeOfFuel typeOfFuel = _typeOfFuelRepository.findOneById(id);
        typeOfFuel.setType(request.getType());

        _typeOfFuelRepository.save(typeOfFuel);

        TypeOfFuelResponse typeOfFuelResponse = new TypeOfFuelResponse();
        typeOfFuelResponse.setType(typeOfFuel.getType());
        typeOfFuelResponse.setId(typeOfFuel.getId());

        return typeOfFuelResponse;
    }

    @Override
    public void deleteTypeOfFuel(long id) {
        TypeOfFuel typeOfFuel = _typeOfFuelRepository.findOneById(id);
        typeOfFuel.setDeleted(true);

        _typeOfFuelRepository.save(typeOfFuel);
    }
}
