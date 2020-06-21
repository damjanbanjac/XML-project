package com.microservices.search.controller;

import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.dto.CarClassDTO;
import com.microservices.search.model.CarClass;
import com.microservices.search.service.ICarClassService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public CarClassDTO getCarClass(@PathVariable Long id) {
        return _carClassService.getCarClass(id);
    }

    @GetMapping
    public List<CarClassDTO> getAllCarClasses() {
        return _carClassService.getAllCarClass();
    }

    @PostMapping(value = "/class")
    public ResponseEntity<CarClassDTO> createCarClass(@RequestBody CarClassDTO carClassDTO) throws Exception {

        CarClassDTO carclassdto = new CarClassDTO();
        carclassdto = _carClassService.createCarClass(carClassDTO);

        return new ResponseEntity<CarClassDTO>(carclassdto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/class")
    public void deleteCarClass(@PathVariable Long id) {
        _carClassService.deleteCarClass(id);
    }
}