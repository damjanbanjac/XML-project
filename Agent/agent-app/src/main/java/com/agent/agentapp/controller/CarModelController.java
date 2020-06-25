package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateCarModelRequest;
import com.agent.agentapp.dto.request.UpdateCarModelRequest;
import com.agent.agentapp.dto.response.CarModelResponse;
import com.agent.agentapp.service.ICarModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
@RequestMapping("/models")
public class CarModelController {

    private final ICarModelService _carModelService;

    public CarModelController(ICarModelService carModelService) {
        _carModelService = carModelService;
    }

    @GetMapping("/{id}/model")
    public CarModelResponse getCarModel(@PathVariable Long id) {
        return _carModelService.getCarModel(id);
    }

    @GetMapping
    public List<CarModelResponse> getAllCarModels() {
        return _carModelService.getAllCarModels();
    }

    @PostMapping
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public CarModelResponse createCarModel(@RequestBody CreateCarModelRequest request) {
        return _carModelService.createCarModel(request);
    }

    @PutMapping("/{id}/model")
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public CarModelResponse updateCarModel(@RequestBody UpdateCarModelRequest request, @PathVariable Long id) {
        return _carModelService.updateCarModel(request, id);
    }

    @DeleteMapping("/{id}/model")
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public void deleteCarModel(@PathVariable Long id) {
        _carModelService.deleteCarModel(id);
    }
}
