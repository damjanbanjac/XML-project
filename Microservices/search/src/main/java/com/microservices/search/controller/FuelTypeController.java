package com.microservices.search.controller;

import com.microservices.search.dto.CarModelDTO;
import com.microservices.search.dto.FuelTypeDTO;
import com.microservices.search.service.IFuelTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/fuel-types")
public class FuelTypeController {

    private final IFuelTypeService _fuelTypeService;

    public FuelTypeController(IFuelTypeService fuelTypeService) {
        _fuelTypeService = fuelTypeService;
    }

    @GetMapping("/{id}/fuel-type")
    public FuelTypeDTO getTypeOfFuel(@PathVariable Long id) {
        return _fuelTypeService.getFuelType(id);
    }

    @GetMapping
    public List<FuelTypeDTO> getAllTypesOfFuel() {
        return _fuelTypeService.getAllFuelTypes();
    }

    @PostMapping(value = "/fuel-type")
    public ResponseEntity<FuelTypeDTO> createCarModel(@RequestBody FuelTypeDTO fuelTypeDTO) throws Exception {

        FuelTypeDTO fueltypedto = new FuelTypeDTO();
        fueltypedto = _fuelTypeService.createFuelType(fuelTypeDTO);

        return new ResponseEntity<FuelTypeDTO>(fueltypedto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/fuel-type")
    public void deleteTypeOfFuel(@PathVariable Long id) {
        _fuelTypeService.deleteFuelType(id);
    }
}