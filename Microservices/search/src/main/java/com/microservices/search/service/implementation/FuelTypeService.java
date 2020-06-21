package com.microservices.search.service.implementation;

import com.microservices.search.dto.FuelTypeDTO;
import com.microservices.search.model.FuelType;
import com.microservices.search.repository.IFuelTypeRepository;
import com.microservices.search.service.IFuelTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypeService implements IFuelTypeService {

    private final IFuelTypeRepository _fuelTypeRepository;

    public FuelTypeService(IFuelTypeRepository fuelTypeRepository) {
        _fuelTypeRepository = fuelTypeRepository;
    }

    @Override
    public FuelTypeDTO getFuelType(long id) {
        FuelType typeOfFuel = _fuelTypeRepository.findOneById(id);

        FuelTypeDTO typeOfFuelResponse = new FuelTypeDTO();
        typeOfFuelResponse.setId(typeOfFuel.getId());
        typeOfFuelResponse.setType(typeOfFuel.getType());

        return typeOfFuelResponse;
    }

    @Override
    public List<FuelTypeDTO> getAllFuelTypes() {
        List<FuelType> typeOfFuels = _fuelTypeRepository.findAllByDeleted(false);

        List<FuelTypeDTO> typeOfFuelResponses = new ArrayList<>();

        for(FuelType typeOfFuel: typeOfFuels) {
            FuelTypeDTO typeOfFuelResponse = new FuelTypeDTO();
            typeOfFuelResponse.setType(typeOfFuel.getType());
            typeOfFuelResponse.setId(typeOfFuel.getId());
            typeOfFuelResponses.add(typeOfFuelResponse);
        }

        return typeOfFuelResponses;
    }

        @Override
        public FuelTypeDTO createFuelType(FuelTypeDTO request) {
            FuelType typeOfFuel = new FuelType();
            typeOfFuel.setType(request.getType());
            typeOfFuel.setDeleted(false);
            _fuelTypeRepository.save(typeOfFuel);
            FuelTypeDTO typeOfFuelResponse = new FuelTypeDTO(typeOfFuel);
            return typeOfFuelResponse;
        }
        /*
        @Override
        public TypeOfFuelResponse updateTypeOfFuel(UpdateTypeOfFuelRequest request, long id) {
            TypeOfFuel typeOfFuel = _typeOfFuelRepository.findOneById(id);
            typeOfFuel.setType(request.getType());
            _typeOfFuelRepository.save(typeOfFuel);
            TypeOfFuelResponse typeOfFuelResponse = new TypeOfFuelResponse();
            typeOfFuelResponse.setType(typeOfFuel.getType());
            typeOfFuelResponse.setId(typeOfFuel.getId());
            return typeOfFuelResponse;
        }
    */
    @Override
    public void deleteFuelType(long id) {
        FuelType typeOfFuel = _fuelTypeRepository.findOneById(id);
        typeOfFuel.setDeleted(true);
        _fuelTypeRepository.save(typeOfFuel);
    }
}