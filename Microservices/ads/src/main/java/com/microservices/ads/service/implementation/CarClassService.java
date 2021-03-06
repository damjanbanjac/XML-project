package com.microservices.ads.service.implementation;



import com.microservices.ads.dto.request.CarClassRequest;
import com.microservices.ads.dto.response.CarClassResponse;
import com.microservices.ads.model.CarClass;
import com.microservices.ads.repository.ICarClassRepository;
import com.microservices.ads.service.ICarClassService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarClassService implements ICarClassService {

    private final ICarClassRepository _carClassRepository;

    public CarClassService(ICarClassRepository carClassRepository) {
        _carClassRepository = carClassRepository;
    }

    @Override
    public CarClassResponse getCarClass(long id) {
        CarClass carClass = _carClassRepository.findOneById(id);

        CarClassResponse carClassResponse = new CarClassResponse();
        carClassResponse.setId(carClass.getId());
        carClassResponse.setCar_class(carClass.getCar_class());

        return carClassResponse;
    }

    @Override
    public List<CarClassResponse> getAllCarClass() {
        List<CarClass> carClasses = _carClassRepository.findAllByDeleted(false);

        List<CarClassResponse> carClassResponses = new ArrayList<>();

        for(CarClass cc: carClasses) {
            CarClassResponse carClassResponse = new CarClassResponse();
            carClassResponse.setId(cc.getId());
            carClassResponse.setCar_class(cc.getCar_class());
            carClassResponses.add(carClassResponse);
        }

        return carClassResponses;
    }

    @Override
    public CarClassResponse createCarClass(CarClassRequest request) {
        CarClass carClass = new CarClass();

        carClass.setCar_class(request.getCar_class());
        carClass.setDeleted(false);

        _carClassRepository.save(carClass);

        CarClassResponse carClassResponse = new CarClassResponse();
        carClassResponse.setId(carClass.getId());
        carClassResponse.setCar_class(carClass.getCar_class());

        return carClassResponse;
    }

    @Override
    public CarClassResponse updateCarClass(CarClassRequest request, long id) {
        CarClass carClass = _carClassRepository.findOneById(id);
        carClass.setCar_class(request.getCar_class());

        _carClassRepository.save(carClass);

        CarClassResponse carClassResponse = new CarClassResponse();
        carClassResponse.setId(carClass.getId());
        carClassResponse.setCar_class(carClass.getCar_class());

        return carClassResponse;
    }

    @Override
    public void deleteCarClass(long id) {
        CarClass carClass = _carClassRepository.findOneById(id);
        carClass.setDeleted(true);

        _carClassRepository.save(carClass);
    }
}
