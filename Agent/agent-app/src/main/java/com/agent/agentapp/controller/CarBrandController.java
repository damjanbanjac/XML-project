package com.agent.agentapp.controller;

import com.agent.agentapp.dto.request.CreateCarBrandRequest;
import com.agent.agentapp.dto.request.UpdateCarBrandRequest;
import com.agent.agentapp.dto.response.CarBrandResponse;
import com.agent.agentapp.service.ICarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "", allowedHeaders = "")
@RequestMapping("/brands")
public class CarBrandController {

    private final ICarBrandService _carBrandService;



//    @Autowired
//    private CarBrandClient carBrandClient;

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
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public CarBrandResponse createCarBrand(@RequestBody CreateCarBrandRequest request) {
        return _carBrandService.createCarBrand(request);
    }

//    @PostMapping
//    public GetcarBrandResponse createBrand(@RequestBody CreateCarBrandRequest request) throws IOException {
//        System.out.println(request.getLabel());
//        System.out.println(request.getName());
//
//        return carBrandClient.createCarBrand(request);
//    }

    @PutMapping("/{id}/brand")
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public CarBrandResponse updateCarBrand(@RequestBody UpdateCarBrandRequest request, @PathVariable Long id) {
        return _carBrandService.updateCarBrand(request, id);
    }

    @DeleteMapping("/{id}/brand")
    // @PreAuthorize("hasAuthority('CRUD-CAR-COMPONENTS')")
    // @PreAuthorize("hasAuthority('AGENT')")
    public void deleteCarBrand(@PathVariable Long id) {
        _carBrandService.deleteCarBrand(id);
    }
}
