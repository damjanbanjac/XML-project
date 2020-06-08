package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateTypeOfGearshiftRequest;
import com.agent.agentapp.dto.request.UpdateTypeOfGearshiftRequest;
import com.agent.agentapp.dto.response.TypeOfGearshiftResponse;
import com.agent.agentapp.service.ITypeOfGearshiftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
