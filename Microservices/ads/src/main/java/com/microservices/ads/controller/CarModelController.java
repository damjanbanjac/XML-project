package com.microservices.ads.controller;


import com.microservices.ads.dto.request.CarModelRequest;
import com.microservices.ads.dto.response.CarModelResponse;
import com.microservices.ads.service.ICarModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public CarModelResponse createCarModel(@RequestBody CarModelRequest request) {
        return _carModelService.createCarModel(request);
    }

    @PutMapping("/{id}/model")
    public CarModelResponse updateCarModel(@RequestBody CarModelRequest request, @PathVariable Long id) {
        return _carModelService.updateCarModel(request, id);
    }

    @DeleteMapping("/{id}/model")
    public void deleteCarModel(@PathVariable Long id) {
        _carModelService.deleteCarModel(id);
    }
}
