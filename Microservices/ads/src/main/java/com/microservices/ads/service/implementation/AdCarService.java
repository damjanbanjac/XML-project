package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.repository.*;
import com.microservices.ads.service.IAdCarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdCarService implements IAdCarService {

    @Autowired
    AdCarRepository adCarRepository;

    @Autowired
    AgentRepository agentRepository;


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

    private final Logger logger = LoggerFactory.getLogger(AdCarService.class);

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

    public List<AdCarResponse> getAllAdsUser(long id) {
        List<com.microservices.ads.dto.response.AdCarResponse> adCarResponses = new ArrayList<>();
        List<AdCar> ads = adCarRepository.findAll();
        for (AdCar ad: ads) {
            if(ad.getUserAd().getId() == id) {
                com.microservices.ads.dto.response.AdCarResponse adCarResponse = new com.microservices.ads.dto.response.AdCarResponse(ad);
                adCarResponses.add(adCarResponse);
            }

        }
        return  adCarResponses;
    }

    public List<AdCarResponse> getAllAdsAgent(long id) {
        List<com.microservices.ads.dto.response.AdCarResponse> adCarResponses = new ArrayList<>();
        List<AdCar> ads = adCarRepository.findAll();
        for (AdCar ad: ads) {
            if(ad.getAgentAd().getId() == id) {
                com.microservices.ads.dto.response.AdCarResponse adCarResponse = new com.microservices.ads.dto.response.AdCarResponse(ad);
                adCarResponses.add(adCarResponse);
            }

        }
        return  adCarResponses;
    }

    public List<AdCar> findAllAds() {
        return adCarRepository.findAll();
    }

    public AdCarResponse createAdAgent(AdCarRequest request,long id) {


        System.out.println(request);


        List<AdCar> adCarList = adCarRepository.findAll();

        for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd()) && ad.getUserAd() != null ) {

            }
        }



            AdCar adCar = new AdCar();
            adCar.setAvailableFrom(request.getAvailableFrom());
            adCar.setAvailableTo(request.getAvailableTo());
            adCar.setCarBrand_id(carBrandRepository.findOneById(request.getCarBrand_id().getId()));
            adCar.setCarClass_id(carClassRepository.findOneById(request.getCarClass_id().getId()));
            adCar.setCity(request.getCity());
            adCar.setCarModel_id(carModelRepository.findOneById(request.getCarModel_id().getId()));
            adCar.setCdw(request.getCdw());
            adCar.setAgentAd(agentRepository.findOneById(id));
            adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findOneById(request.getFuelType_id().getId()));
            adCar.setGearShiftCar_id(typeOfGearShiftRepository.findOneById(request.getGearShift_id().getId()));
            adCar.setKidsSeats(request.getKidsSeats());
            adCar.setKmTraveled(request.getKmTraveled());
            adCar.setKmRestriction(request.getKmRestriction());
            adCarSuccessLog();
            adCarRepository.save(adCar);
            AdCarResponse carResponse  = new AdCarResponse(adCar);
            return  carResponse;



    }

    public AdCarResponse createAd(AdCarRequest request) {

        Integer cnt = 0;

        System.out.println(request);


        List<AdCar> adCarList = adCarRepository.findAll();

        for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd()) && ad.getUserAd() != null ) {
                cnt++;
            }
        }
         System.out.println(cnt);
        if(cnt < 3) {

            AdCar adCar = new AdCar();
            adCar.setAvailableFrom(request.getAvailableFrom());
            adCar.setAvailableTo(request.getAvailableTo());
            adCar.setCarBrand_id(carBrandRepository.findOneById(request.getCarBrand_id().getId()));
            adCar.setCarClass_id(carClassRepository.findOneById(request.getCarClass_id().getId()));
            adCar.setCity(request.getCity());
            adCar.setCarModel_id(carModelRepository.findOneById(request.getCarModel_id().getId()));
            adCar.setCdw(request.getCdw());
           // adCar.setUserAd(userAdRepository.findOneById(request.getUserAd()));
            adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findOneById(request.getFuelType_id().getId()));
            adCar.setGearShiftCar_id(typeOfGearShiftRepository.findOneById(request.getGearShift_id().getId()));
            adCar.setKidsSeats(request.getKidsSeats());
            adCar.setKmTraveled(request.getKmTraveled());
            adCar.setKmRestriction(request.getKmRestriction());


            adCarRepository.save(adCar);
            AdCarResponse carResponse  = new AdCarResponse(adCar);
            return  carResponse;

        }
        createCarFailedLog();
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
        adCar.setCity(request.getCity());
        // adCar.setUserAd(userAdRepository.findById(request.getUserAd()).orElse(null));
        adCar.setFuelTypeCar_id(typeOfFuelTypeRepository.findOneById(request.getFuelType_id().getId()));
        adCar.setGearShiftCar_id(typeOfGearShiftRepository.findOneById(request.getGearShift_id().getId()));
        adCar.setKidsSeats(request.getKidsSeats());
        adCar.setKmTraveled(request.getKmTraveled());
        adCar.setKmRestriction(request.getKmRestriction());
        updateCarSuccessLog();
        adCarRepository.save(adCar);
        AdCarResponse response = new AdCarResponse(adCar);
        return response;
    }

    @Override
    public void deleteAdCar(long id) {
        deleteCarSuccessLog();
        adCarRepository.deleteById(id);


    }

    @Override
    public Integer getAverageGrade(long id) {
        return null;
    }


    public void adCarSuccessLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Agent successfully added a car.");
//        }
    }

    public void updateCarSuccessLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Agent successfully updated a car.");
//        }
    }

    public void deleteCarSuccessLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS Agent successfully deleted a car.");
//        }
    }

    public void createCarFailedLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE Agent failed to create car.");
//        }
    }

    public void updateCarFailedLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE Agent failed to update car.");
//        }
    }

    public void deleteCarFailedLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE Agent failed to delete car.");
//        }
    }

}

