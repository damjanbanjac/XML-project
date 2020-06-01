package com.microservices.maintenance.controller;

import com.microservices.maintenance.dto.request.CreateCarBrandRequest;
import com.microservices.maintenance.dto.request.UpdateCarBrandRequest;
import com.microservices.maintenance.dto.response.CarBrandResponse;
import com.microservices.maintenance.service.ICarBrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class CarBrandController {

    private final ICarBrandService _carBrandService;

    public CarBrandController(ICarBrandService carBrandService) {
        _carBrandService = carBrandService;
    }

    @GetMapping
    public List<CarBrandResponse> getAllCarBrands() {
        return _carBrandService.getAllCarBrands();
    }

    @GetMapping("/{id}/brand")
    public CarBrandResponse getCarBrand(@PathVariable Long id) {
        return _carBrandService.getCarBrand(id);
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
