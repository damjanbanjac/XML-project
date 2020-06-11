package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.repository.*;
import com.microservices.ads.service.IAdCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<AdCarResponse> adCarResponses = new ArrayList<>();
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
            adCar.setCarBrand_id(carBrandRepository.findOneById(request.getCarBrand_id().getId()));
            adCar.setCarClass_id(carClassRepository.findOneById(request.getCarClass_id().getId()));

            adCar.setCarModel_id(carModelRepository.findOneById(request.getCarModel_id().getId()));
            adCar.setCdw(request.getCdw());
            // adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
            adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findOneById(request.getFuelType_id().getId()));
            adCar.setGearShiftCar_id(typeOfGearShiftRepository.findOneById(request.getGearShift_id().getId()));
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

        AdCar adCar = adCarRepository.findOneById(id);
        adCar.setAvailableFrom(request.getAvailableFrom());
        adCar.setAvailableTo(request.getAvailableTo());
        adCar.setCarBrand_id(carBrandRepository.findOneById(request.getCarBrand_id().getId()));
        adCar.setCarClass_id(carClassRepository.findOneById(request.getCarClass_id().getId()));

        adCar.setCarModel_id(carModelRepository.findOneById(request.getCarModel_id().getId()));
        adCar.setCdw(request.getCdw());
        adCar.setCity(request.getSity());
        // adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
        adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findOneById(request.getFuelType_id().getId()));
        adCar.setGearShiftCar_id(typeOfGearShiftRepository.findOneById(request.getGearShift_id().getId()));
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

