package com.microservices.ads.controller;


import com.microservices.ads.dto.request.CarClassRequest;
import com.microservices.ads.dto.response.CarClassResponse;
import com.microservices.ads.service.ICarClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/classes")
public class CarClassController {

    private final ICarClassService _carClassService;

    public CarClassController(ICarClassService carClassService) {
        _carClassService = carClassService;
    }

    @GetMapping("/{id}/class")
    public CarClassResponse getCarClass(@PathVariable Long id) {
        return _carClassService.getCarClass(id);
    }

    @GetMapping
    public List<CarClassResponse> getAllCarClasses() {
        return _carClassService.getAllCarClass();
    }

    @PostMapping
    public CarClassResponse createCarClass(@RequestBody CarClassRequest request) {
        return _carClassService.createCarClass(request);
    }

    @PutMapping("/{id}/class")
    public CarClassResponse updateCarClass(@RequestBody CarClassRequest request, @PathVariable Long id) {
        return _carClassService.updateCarClass(request, id);
    }

    @DeleteMapping("/{id}/class")
    public void deleteCarClass(@PathVariable Long id) {
        _carClassService.deleteCarClass(id);
    }
}
