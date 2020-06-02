package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.repository.AdCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdsCarService implements IAdsCarService {

    @Autowired
    AdCarRepository adCarRepository;
    
    @Override
    public AdCarResponse getAd(long id) {
        return null;
    }

    @Override
    public List<AdCarResponse> getAllAds() {
        return null;
    }

    public List<AdCar> findAllAds() {
        return adCarRepository.findAll();
    }

    public AdCarResponse createAd(AdCarRequest request) {

        Integer cnt = 0;

        List<AdCar> adCarList = adCarRepository.findAll();

        for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd().getId())) {
                cnt++;
            }
        }
        if(cnt != 3) {

            AdCar adCar = new AdCar();
            adCar.setAvailableFrom(request.getAvailableFrom());
            adCar.setAvailableTo(request.getAvailableTo());
            adCar.setCarBrand(request.getCarBrand());
            adCar.setCarClass(request.getCarClass());
            adCar.setCarModel(request.getCarModel());
            adCar.setCdw(request.getCdw());
            adCar.setUserAd(request.getUserAd());
            adCar.setFuelType(request.getFuelType());
            adCar.setGearBoxType(request.getGearBoxType());
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
        adCar.setCarBrand(request.getCarBrand());
        adCar.setCarClass(request.getCarClass());
        adCar.setCarModel(request.getCarModel());
        adCar.setCdw(request.getCdw());
        adCar.setUserAd(request.getUserAd());
        adCar.setFuelType(request.getFuelType());
        adCar.setGearBoxType(request.getGearBoxType());
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
