package com.microservices.search.service;

import com.microservices.search.dto.FuelTypeDTO;
import com.microservices.search.model.FuelType;

import java.util.List;

public interface IFuelTypeService {

    FuelTypeDTO getFuelType(long id);

    FuelTypeDTO createFuelType(FuelTypeDTO fuelTypeDTO);

    List<FuelTypeDTO> getAllFuelTypes();

    void deleteFuelType(long id);
}
