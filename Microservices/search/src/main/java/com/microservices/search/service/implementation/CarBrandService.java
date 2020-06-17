package com.microservices.search.service.implementation;

import com.microservices.search.dto.CarBrandDTO;
import com.microservices.search.model.CarBrand;
import com.microservices.search.repository.ICarBrandRepository;
import com.microservices.search.service.ICarBrandService;
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
    public CarBrandDTO getCarBrand(long id) {
        CarBrand carBrand = _carBrandRepository.findOneById(id);

        CarBrandDTO carBrandResponse = new CarBrandDTO();
        carBrandResponse.setId(carBrand.getId());
        carBrandResponse.setLabel(carBrand.getLabel());
        carBrandResponse.setName(carBrand.getName());

        return carBrandResponse;
    }

    @Override
    public List<CarBrandDTO> getAllCarBrands() {
        List<CarBrand> carBrands = _carBrandRepository.findAllByDeleted(false);

        List<CarBrandDTO> carBrandResponses = new ArrayList<>();

        for(CarBrand cb: carBrands) {
            CarBrandDTO carBrandResponse = new CarBrandDTO();
            carBrandResponse.setId(cb.getId());
            carBrandResponse.setLabel(cb.getLabel());
            carBrandResponse.setName(cb.getName());
            carBrandResponses.add(carBrandResponse);
        }

        return carBrandResponses;
    }

    @Override
    public CarBrandDTO createCarBrand(CarBrandDTO request) {
        CarBrand carBrand = new CarBrand();
        carBrand.setLabel(request.getLabel());
        carBrand.setName(request.getName());
        carBrand.setDeleted(false);
        _carBrandRepository.save(carBrand);
        CarBrandDTO carbranddto = new CarBrandDTO(carBrand);
        return carbranddto;
    }

    /*   @Override
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
   */
    @Override
    public void deleteCarBrand(long id) {
        CarBrand carBrand = _carBrandRepository.findOneById(id);
        carBrand.setDeleted(true);
        _carBrandRepository.save(carBrand);
    }

}