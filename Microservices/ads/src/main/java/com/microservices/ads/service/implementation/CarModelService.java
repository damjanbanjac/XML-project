package com.microservices.ads.service.implementation;


import com.microservices.ads.dto.response.CarModelResponse;
import com.microservices.ads.model.CarModel;
import com.microservices.ads.repository.ICarModelRepository;
import com.microservices.ads.service.ICarModelService;
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
    public CarModelResponse getCarModel(long id) {
        CarModel carModel = _carModelRepository.findOneById(id);

        CarModelResponse carModelResponse = new CarModelResponse();
        carModelResponse.setId(carModel.getId());
        carModelResponse.setModel(carModel.getModel());

        return carModelResponse;
    }

    @Override
    public List<CarModelResponse> getAllCarModels() {
        List<CarModel> carModels = _carModelRepository.findAllByDeleted(false);

        List<CarModelResponse> carModelResponses = new ArrayList<>();

        for(CarModel cm: carModels) {
            CarModelResponse carModelResponse = new CarModelResponse();
            carModelResponse.setId(cm.getId());
            carModelResponse.setModel(cm.getModel());
            carModelResponses.add(carModelResponse);
        }

        return carModelResponses;
    }

 /*   @Override
    public CarModelResponse createCarModel(CreateCarModelRequest request) {
        CarModel carModel = new CarModel();
        carModel.setModel(request.getModel());
        carModel.setDeleted(false);

        _carModelRepository.save(carModel);

        CarModelResponse carModelResponse = new CarModelResponse();
        carModelResponse.setId(carModel.getId());
        carModelResponse.setModel(carModel.getModel());

        return carModelResponse;
    }

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
