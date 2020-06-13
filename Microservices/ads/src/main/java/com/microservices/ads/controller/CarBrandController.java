package com.microservices.ads.controller;


import com.microservices.ads.dto.response.CarBrandResponse;
import com.microservices.ads.service.ICarBrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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



    @DeleteMapping("/{id}/brand")
    public void deleteCarBrand(@PathVariable Long id) {
        _carBrandService.deleteCarBrand(id);
    }
}
