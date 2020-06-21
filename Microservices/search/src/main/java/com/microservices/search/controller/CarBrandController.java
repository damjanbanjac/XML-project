package com.microservices.search.controller;


import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.service.ICarBrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public CarBrandDTO getCarBrand(@PathVariable Long id) {
        return _carBrandService.getCarBrand(id);
    }

    @GetMapping
    public List<CarBrandDTO> getAllCarBrands() {
        return _carBrandService.getAllCarBrands();
    }

    @PostMapping(value = "/brand")
    public ResponseEntity<CarBrandDTO> createCarBrand(@RequestBody CarBrandDTO carBrandDTO) throws Exception {

        CarBrandDTO carbranddto = new CarBrandDTO();
        carbranddto = _carBrandService.createCarBrand(carBrandDTO);

        return new ResponseEntity<>(carbranddto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/brand")
    public void deleteCarBrand(@PathVariable Long id) {
        _carBrandService.deleteCarBrand(id);
    }
}