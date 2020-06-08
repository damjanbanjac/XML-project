package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateCarClassRequest;
import com.agent.agentapp.dto.request.UpdateCarClassRequest;
import com.agent.agentapp.dto.response.CarClassResponse;
import com.agent.agentapp.service.ICarClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public CarClassResponse createCarClass(@RequestBody CreateCarClassRequest request) {
        return _carClassService.createCarClass(request);
    }

    @PutMapping("/{id}/class")
    public CarClassResponse updateCarClass(@RequestBody UpdateCarClassRequest request, @PathVariable Long id) {
        return _carClassService.updateCarClass(request, id);
    }

    @DeleteMapping("/{id}/class")
    public void deleteCarClass(@PathVariable Long id) {
        _carClassService.deleteCarClass(id);
    }
}
