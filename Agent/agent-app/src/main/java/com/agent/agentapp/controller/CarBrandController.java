package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateCarBrandRequest;
import com.agent.agentapp.dto.request.UpdateCarBrandRequest;
import com.agent.agentapp.dto.response.CarBrandResponse;
import com.agent.agentapp.service.ICarBrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class CarBrandController {

    private final ICarBrandService _carBrandService;

    public CarBrandController(ICarBrandService carBrandService) {
        _carBrandService = carBrandService;
    }

    @GetMapping("/{id}/brand")
    public CarBrandResponse getCarBrand(@PathVariable Long id) {
        return _carBrandService.getCarBrand(id);
    }

    @GetMapping
    public List<CarBrandResponse> getAllCarBrands() {
        return _carBrandService.getAllCarBrands();
    }

    @PostMapping
    public CarBrandResponse createCarBrand(@RequestBody CreateCarBrandRequest request) {
        return _carBrandService.createCarBrand(request);
    }

    @PutMapping("/{id}/brand")
    public CarBrandResponse updateCarBrand(@RequestBody UpdateCarBrandRequest request, @PathVariable Long id) {
        return _carBrandService.updateCarBrand(request, id);
    }

    @DeleteMapping("/{id}/brand")
    public void deleteCarBrand(@PathVariable Long id) {
        _carBrandService.deleteCarBrand(id);
    }
}
