package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.AdCarRequest;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.IAdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdCarService implements IAdCarService {

    @Autowired
    AdCarRepository adCarRepository;

    @Autowired
    ICarBrandRepository carBrandRepository;


    @Autowired
    IUserRepository userAdRepository;

    @Autowired
    ICarModelRepository carModelRepository;

    @Autowired
    ICarClassRepository carClassRepository;

    @Autowired
    ITypeOfFuelRepository typeOfFuelTypeRepository;

    @Autowired
    ITypeOfGearshiftRepository typeOfGearShiftRepository;

    @Override
    public AdCarResponse getAd(long id) {
        AdCar adCar = adCarRepository.findOneById(id);
        AdCarResponse adCarResponse = new AdCarResponse(adCar);
        return  adCarResponse;

    }

    @Override
    public List<AdCarResponse> getAllAds() {
        List<AdCarResponse> adCarResponses = null;
        List<AdCar> ads = adCarRepository.findAll();
        for (AdCar ad: ads) {
            AdCarResponse adCarResponse = new AdCarResponse(ad);
            adCarResponses.add(adCarResponse);
        }
        return  adCarResponses;
    }

    public List<AdCar> findAllAds() {
        return adCarRepository.findAll();
    }

    public AdCarResponse createAd(AdCarRequest request) {

        Integer cnt = 0;

        System.out.println(request);


        List<AdCar> adCarList = adCarRepository.findAll();

        /*for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd())) {
                cnt++;
            }
        } */
       // System.out.println(cnt);
        if(cnt < 3) {

            AdCar adCar = new AdCar();
            adCar.setAvailableFrom(request.getAvailableFrom());
            adCar.setAvailableTo(request.getAvailableTo());
            adCar.setCarBrand_id(carBrandRepository.findById(request.getCarBrand_id()).orElse(null));
            adCar.setCarClass_id(carClassRepository.findById(request.getCarClass_id()).orElse(null));

            adCar.setCarModel_id(carModelRepository.findById(request.getCarModel_id()).orElse(null));
            adCar.setCdw(request.getCdw());
            adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
            adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findById(request.getFuelType_id()).orElse(null));
            adCar.setGearShiftCar_id(typeOfGearShiftRepository.findById(request.getGearShift_id()).orElse(null));
            adCar.setKidsSeats(request.getKidsSeats());
            adCar.setKmTraveled(request.getKmTraveled());
            adCar.setKmRestriction(request.getKmRestriction());


            adCarRepository.save(adCar);
            AdCarResponse carResponse  = new AdCarResponse(adCar);
            return  carResponse;

        }
        return null;
    }

    @Override
    public AdCarResponse updateAd(AdCarRequest request, long id) {

        AdCar adCar = adCarRepository.findById(id);
        adCar.setAvailableFrom(request.getAvailableFrom());
        adCar.setAvailableTo(request.getAvailableTo());
        adCar.setCarBrand_id(carBrandRepository.findById(request.getCarBrand_id()).orElse(null));
        adCar.setCarClass_id(carClassRepository.findById(request.getCarClass_id()).orElse(null));
        adCar.setCarModel_id(carModelRepository.findById(request.getCarModel_id()).orElse(null));
        adCar.setCdw(request.getCdw());
        adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
        adCar.setGearShiftCar_id(typeOfGearShiftRepository.findById(request.getGearShift_id()).orElse(null));
        adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findById(request.getFuelType_id()).orElse(null));
        adCar.setKidsSeats(request.getKidsSeats());
        adCar.setKmTraveled(request.getKmTraveled());
        adCar.setKmRestriction(request.getKmRestriction());
        adCarRepository.save(adCar);
        AdCarResponse response = new AdCarResponse(adCar);
        return response;
    }

    @Override
    public void deleteAdCar(long id) {
        adCarRepository.deleteById(id);


    }

    @Override
    public Integer getAverageGrade(long id) {
        return null;
    }
}
