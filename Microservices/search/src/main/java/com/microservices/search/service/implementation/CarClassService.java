package com.microservices.search.service.implementation;

import com.microservices.search.dto.CarClassDTO;
import com.microservices.search.model.CarClass;
import com.microservices.search.repository.ICarClassRepository;
import com.microservices.search.service.ICarClassService;
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
    public CarClassDTO getCarClass(long id) {
        CarClass carClass = _carClassRepository.findOneById(id);

        CarClassDTO carClassResponse = new CarClassDTO();
        carClassResponse.setId(carClass.getId());
        carClassResponse.setCar_class(carClass.getCar_class());

        return carClassResponse;
    }

    @Override
    public List<CarClassDTO> getAllCarClass() {
        List<CarClass> carClasses = _carClassRepository.findAllByDeleted(false);

        List<CarClassDTO> carClassResponses = new ArrayList<>();

        for(CarClass cc: carClasses) {
            CarClassDTO carClassResponse = new CarClassDTO();
            carClassResponse.setId(cc.getId());
            carClassResponse.setCar_class(cc.getCar_class());
            carClassResponses.add(carClassResponse);
        }

        return carClassResponses;
    }

      @Override
      public CarClassDTO createCarClass(CarClassDTO request) {
          CarClass carClass = new CarClass();
          carClass.setCar_class(request.getCar_class());
          carClass.setDeleted(false);
          _carClassRepository.save(carClass);
          CarClassDTO carClassResponse = new CarClassDTO(carClass);
          return carClassResponse;
      }

      /*
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
  */
    @Override
    public void deleteCarClass(long id) {
        CarClass carClass = _carClassRepository.findOneById(id);
        carClass.setDeleted(true);

        _carClassRepository.save(carClass);
    }
}