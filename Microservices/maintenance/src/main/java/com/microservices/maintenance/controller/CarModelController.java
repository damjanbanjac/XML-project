package com.microservices.maintenance.controller;

import com.microservices.maintenance.dto.request.CreateCarModelRequest;
import com.microservices.maintenance.dto.request.UpdateCarModelRequest;
import com.microservices.maintenance.dto.response.CarModelResponse;
import com.microservices.maintenance.service.ICarModelService;
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
    public CarModelResponse createCarModel(@RequestBody CreateCarModelRequest request) {
        return _carModelService.createCarModel(request);
    }

    @PutMapping("/{id}/model")
    public CarModelResponse updateCarModel(@RequestBody UpdateCarModelRequest request, @PathVariable Long id) {
        return _carModelService.updateCarModel(request, id);
    }

    @DeleteMapping("/{id}/model")
    public void deleteCarModel(@PathVariable Long id) {
        _carModelService.deleteCarModel(id);
    }
}
