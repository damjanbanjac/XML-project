package com.microservices.ads.controller;


import com.microservices.ads.dto.request.TypeOfFuelRequest;
import com.microservices.ads.dto.response.TypeOfFuelResponse;
import com.microservices.ads.service.ITypeOfFuelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/fuel-types")
public class TypeOfFuelController {

    private final ITypeOfFuelService _typeOfFuelService;

    public TypeOfFuelController(ITypeOfFuelService typeOfFuelService) {
        _typeOfFuelService = typeOfFuelService;
    }

    @GetMapping("/{id}/fuel-type")
    public TypeOfFuelResponse getTypeOfFuel(@PathVariable Long id) {
        return _typeOfFuelService.getTypeOfFuel(id);
    }

    @GetMapping
    public List<TypeOfFuelResponse> getAllTypesOfFuel() {
        return _typeOfFuelService.getAllTypesOfFuel();
    }

    @PostMapping()
    public TypeOfFuelResponse createTypeOfFuel(@RequestBody TypeOfFuelRequest request) {
        return _typeOfFuelService.createTypeOfFuel(request);
    }

    @PutMapping("/{id}/fuel-type")
    public TypeOfFuelResponse updateTypeOfFuel(@RequestBody TypeOfFuelRequest request, @PathVariable Long id) {
        return _typeOfFuelService.updateTypeOfFuel(request, id);
    }

    @DeleteMapping("/{id}/fuel-type")
    public void deleteTypeOfFuel(@PathVariable Long id) {
        _typeOfFuelService.deleteTypeOfFuel(id);
    }
}
