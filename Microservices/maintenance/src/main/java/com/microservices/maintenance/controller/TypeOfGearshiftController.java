package com.microservices.maintenance.controller;

import com.microservices.maintenance.dto.request.CreateTypeOfGearshiftRequest;
import com.microservices.maintenance.dto.request.UpdateTypeOfGearshiftRequest;
import com.microservices.maintenance.dto.response.TypeOfGearshiftResponse;
import com.microservices.maintenance.service.ITypeOfGearshiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
@RequestMapping("gearshift-types")
public class TypeOfGearshiftController {

    private final ITypeOfGearshiftService _typeOfGearshiftService;

    public TypeOfGearshiftController(ITypeOfGearshiftService typeOfGearshiftService) {
        _typeOfGearshiftService = typeOfGearshiftService;
    }

    @GetMapping("/{id}/gearshift-type")
    public TypeOfGearshiftResponse getTypeOfGearshift(@PathVariable Long id) {
        return _typeOfGearshiftService.getTypeOfGearshift(id);
    }

    @GetMapping
    public List<TypeOfGearshiftResponse> getAllTypesOfGearshift() {
        return _typeOfGearshiftService.getAllTypesOfGearshifts();
    }

    @PostMapping
    public TypeOfGearshiftResponse createTypeOfGearshift(@RequestBody CreateTypeOfGearshiftRequest request) {
        return _typeOfGearshiftService.createTypeOfGearshift(request);
    }

    @PutMapping("/{id}/gearshift-type")
    public TypeOfGearshiftResponse updateTypeOfGearshift(@RequestBody UpdateTypeOfGearshiftRequest request, @PathVariable Long id) {
        return _typeOfGearshiftService.updateTypeOfGearshift(request, id);
    }

    @DeleteMapping("/{id}/gearshift-type")
    public void deleteTypeOfGearshift(@PathVariable Long id) {
        _typeOfGearshiftService.deleteTypeOfGearshift(id);
    }
}
