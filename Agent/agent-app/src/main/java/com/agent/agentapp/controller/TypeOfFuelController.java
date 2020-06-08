package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateTypeOfFuelRequest;
import com.agent.agentapp.dto.request.UpdateTypeOfFuelRequest;
import com.agent.agentapp.dto.response.TypeOfFuelResponse;
import com.agent.agentapp.service.ITypeOfFuelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public TypeOfFuelResponse createTypeOfFuel(@RequestBody CreateTypeOfFuelRequest request) {
        return _typeOfFuelService.createTypeOfFuel(request);
    }

    @PutMapping("/{id}/fuel-type")
    public TypeOfFuelResponse updateTypeOfFuel(@RequestBody UpdateTypeOfFuelRequest request, @PathVariable Long id) {
        return _typeOfFuelService.updateTypeOfFuel(request, id);
    }

    @DeleteMapping("/{id}/fuel-type")
    public void deleteTypeOfFuel(@PathVariable Long id) {
        _typeOfFuelService.deleteTypeOfFuel(id);
    }
}
