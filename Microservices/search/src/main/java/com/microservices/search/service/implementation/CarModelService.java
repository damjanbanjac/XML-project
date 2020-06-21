package com.microservices.search.service.implementation;

import com.microservices.search.dto.CarModelDTO;
import com.microservices.search.model.CarModel;
import com.microservices.search.repository.ICarModelRepository;
import com.microservices.search.service.ICarModelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarModelService implements ICarModelService {

    private final ICarModelRepository _carModelRepository;

    public CarModelService(ICarModelRepository carModelRepository) {
        _carModelRepository = carModelRepository;
    }

    @Override
    public CarModelDTO getCarModel(long id) {
        CarModel carModel = _carModelRepository.findOneById(id);

        CarModelDTO carModelResponse = new CarModelDTO();
        carModelResponse.setId(carModel.getId());
        carModelResponse.setModel(carModel.getModel());

        return carModelResponse;
    }

    @Override
    public List<CarModelDTO> getAllCarModels() {
        List<CarModel> carModels = _carModelRepository.findAllByDeleted(false);

        List<CarModelDTO> carModelResponses = new ArrayList<>();

        for(CarModel cm: carModels) {
            CarModelDTO carModelResponse = new CarModelDTO();
            carModelResponse.setId(cm.getId());
            carModelResponse.setModel(cm.getModel());
            carModelResponses.add(carModelResponse);
        }

        return carModelResponses;
    }

       @Override
       public CarModelDTO createCarModel(CarModelDTO request) {
           CarModel carModel = new CarModel();
           carModel.setModel(request.getModel());
           carModel.setDeleted(false);
           _carModelRepository.save(carModel);
           CarModelDTO carModelResponse = new CarModelDTO(carModel);
           return carModelResponse;
       }
       /*
       @Override
       public CarModelResponse updateCarModel(UpdateCarModelRequest request, long id) {
           CarModel carModel = _carModelRepository.findOneById(id);
           carModel.setModel(request.getModel());
           _carModelRepository.save(carModel);
           CarModelResponse carModelResponse = new CarModelResponse();
           carModelResponse.setModel(carModel.getModel());
           carModelResponse.setId(carModel.getId());
           return carModelResponse;
       }
   */
    @Override
    public void deleteCarModel(long id) {
        CarModel carModel = _carModelRepository.findOneById(id);
        carModel.setDeleted(true);

        _carModelRepository.save(carModel);
    }
}