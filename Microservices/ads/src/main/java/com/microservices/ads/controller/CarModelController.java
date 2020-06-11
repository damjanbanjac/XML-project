package com.microservices.ads.controller;


import com.microservices.ads.dto.response.CarModelResponse;
import com.microservices.ads.service.ICarModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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



    @DeleteMapping("/{id}/model")
    public void deleteCarModel(@PathVariable Long id) {
        _carModelService.deleteCarModel(id);
    }
}
