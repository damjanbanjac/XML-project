package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.CreateCarClassRequest;
import com.agent.agentapp.dto.request.UpdateCarClassRequest;
import com.agent.agentapp.dto.response.CarClassResponse;
import com.agent.agentapp.entity.CarClass;
import com.agent.agentapp.repository.ICarClassRepository;
import com.agent.agentapp.service.ICarClassService;
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
    public CarClassResponse createCarClass(CreateCarClassRequest request) {
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
    public CarClassResponse updateCarClass(UpdateCarClassRequest request, long id) {
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
