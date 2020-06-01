package com.microservices.maintenance.service.implementation;

import com.microservices.maintenance.dto.request.CreateCarBrandRequest;
import com.microservices.maintenance.dto.request.UpdateCarBrandRequest;
import com.microservices.maintenance.dto.response.CarBrandResponse;
import com.microservices.maintenance.entity.CarBrand;
import com.microservices.maintenance.repository.ICarBrandRepository;
import com.microservices.maintenance.service.ICarBrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarBrandService implements ICarBrandService {

    private final ICarBrandRepository _carBrandRepository;

    public CarBrandService(ICarBrandRepository carBrandRepository) {
        _carBrandRepository = carBrandRepository;
    }

    @Override
    public CarBrandResponse getCarBrand(long id) {
        CarBrand carBrand = _carBrandRepository.findOneById(id);

        CarBrandResponse carBrandResponse = new CarBrandResponse();
        carBrandResponse.setId(carBrand.getId());
        carBrandResponse.setLabel(carBrand.getLabel());
        carBrandResponse.setName(carBrand.getName());

        return carBrandResponse;
    }

    @Override
    public List<CarBrandResponse> getAllCarBrands() {
        List<CarBrand> carBrands = _carBrandRepository.findAllByDeleted(false);

        List<CarBrandResponse> carBrandResponses = new ArrayList<>();

        for(CarBrand cb: carBrands) {
            CarBrandResponse carBrandResponse = new CarBrandResponse();
            carBrandResponse.setId(cb.getId());
            carBrandResponse.setLabel(cb.getLabel());
            carBrandResponse.setName(cb.getName());
            carBrandResponses.add(carBrandResponse);
        }

        return carBrandResponses;
    }

    @Override
    public CarBrandResponse createCarBrand(CreateCarBrandRequest request) {
        CarBrand carBrand = new CarBrand();

        carBrand.setLabel(request.getLabel());
        carBrand.setName(request.getName());
        carBrand.setDeleted(false);

        _carBrandRepository.save(carBrand);

        CarBrandResponse carBrandResponse = new CarBrandResponse();
        carBrandResponse.setId(carBrand.getId());
        carBrandResponse.setLabel(carBrand.getLabel());
        carBrandResponse.setName(carBrand.getName());

        return carBrandResponse;
    }

    @Override
    public CarBrandResponse updateCarBrand(UpdateCarBrandRequest request, long id) {
        CarBrand carBrand = _carBrandRepository.findOneById(id);
        carBrand.setName(request.getName());
        carBrand.setLabel(request.getLabel());

        _carBrandRepository.save(carBrand);

        CarBrandResponse carBrandResponse = new CarBrandResponse();
        carBrandResponse.setName(carBrand.getName());
        carBrandResponse.setLabel(carBrand.getLabel());

        return carBrandResponse;
    }

    @Override
    public void deleteCarBrand(long id) {
        CarBrand carBrand = _carBrandRepository.findOneById(id);
        carBrand.setDeleted(true);
        _carBrandRepository.save(carBrand);
    }

}
