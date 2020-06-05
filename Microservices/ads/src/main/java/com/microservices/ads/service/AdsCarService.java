package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.*;
import com.microservices.ads.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdsCarService implements IAdsCarService {

    @Autowired
    AdCarRepository adCarRepository;

    @Autowired
    CarBrandRepository carBrandRepository;


    @Autowired
    UserAdRepository userAdRepository;

    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    CarClassRepository carClassRepository;

    @Autowired
    TypeOfFuelTypeRepository typeOfFuelTypeRepository;

    @Autowired
    TypeOfGearShiftRepository typeOfGearShiftRepository;

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
      /*  CarModel c = new CarModel();
        carModelRepository.save(c);

        CarClass cc = new CarClass();
        carClassRepository.save(cc);

        CarBrand cb = new CarBrand();
        carBrandRepository.save(cb);

        UserAd u = new UserAd();
        userAdRepository.save(u);
        System.out.println(userAdRepository.findById()); */
     //   UserAd u = new UserAd();
       // userAdRepository.save(u);
        Integer cnt = 0;
        /*TypeOfFuelCar t = new TypeOfFuelCar();
        typeOfFuelTypeRepository.save(t);
        TypeOfGearshiftCar g = new TypeOfGearshiftCar();
        typeOfGearShiftRepository.save(g); */
     //   CarBrand c =new CarBrand();
       // c.setName("mercedes");
       // carBrandRepository.save(c);
        System.out.println(request.getUserAd());
        List<AdCar> adCarList = adCarRepository.findAll();

        for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd())) {
                cnt++;
            }
        }
        System.out.println(cnt);
        if(cnt < 3) {

            AdCar adCar = new AdCar();
            adCar.setAvailableFrom(request.getAvailableFrom());
            adCar.setAvailableTo(request.getAvailableTo());
            //adCar.setCarBrand(carBrandRepository.findById(request.getCarBrand_id()));
            adCar.setCarBrand_id(carBrandRepository.findById(request.getCarBrand_id()).orElse(null));
            adCar.setCarClass_id(carClassRepository.findById(request.getCarClass_id()).orElse(null));

            adCar.setCarModel_id(carModelRepository.findById(request.getCarModel_id()).orElse(null));
            adCar.setCdw(request.getCdw());
            adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
           // adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findById(request.getFuelType_id()).orElse(null));
            //adCar.setGearShiftCar_id(typeOfGearShiftRepository.findById(request.getGearShift_id()).orElse(null));
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
        //adCar.setGearShiftCar_id(typeOfGearShiftRepository.findById(request.getGearShift_id()).orElse(null));
        //adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findById(request.getFuelType_id()).orElse(null));
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
