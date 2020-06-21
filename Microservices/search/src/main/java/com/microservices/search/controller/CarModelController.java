package com.microservices.search.controller;

import com.microservices.search.dto.CarClassDTO;
import com.microservices.search.dto.CarModelDTO;
import com.microservices.search.model.CarModel;
import com.microservices.search.service.ICarModelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public CarModelDTO getCarModel(@PathVariable Long id) {
        return _carModelService.getCarModel(id);
    }

    @GetMapping
    public List<CarModelDTO> getAllCarModels() {
        return _carModelService.getAllCarModels();
    }

    @PostMapping(value = "/model")
    public ResponseEntity<CarModelDTO> createCarModel(@RequestBody CarModelDTO carModelDTO) throws Exception {

        CarModelDTO carmodeldto = new CarModelDTO();
        carmodeldto = _carModelService.createCarModel(carModelDTO);

        return new ResponseEntity<CarModelDTO>(carmodeldto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/model")
    public void deleteCarModel(@PathVariable Long id) {
        _carModelService.deleteCarModel(id);
    }
}