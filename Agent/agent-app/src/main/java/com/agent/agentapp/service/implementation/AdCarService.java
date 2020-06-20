package com.agent.agentapp.service.implementation;

import com.agent.agentapp.dto.request.AdCarRequest;
import com.agent.agentapp.dto.response.AdCarResponse;
import com.agent.agentapp.entity.AdCar;
import com.agent.agentapp.entity.Order;
import com.agent.agentapp.repository.*;
import com.agent.agentapp.service.IAdCarService;
import com.agent.agentapp.service.IAgentService;

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
    AgentRepository agentRepository;

    @Autowired
    IOrderRepository orderRepository;

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


    public List<AdCarResponse> getAllAdsAgent(long id) {
       List<AdCarResponse> adCarResponses = new ArrayList<>();
        List<AdCar> ads = adCarRepository.findAll();
        for (AdCar ad: ads) {
            if(ad.getAgentAd().getId() == id) {
               AdCarResponse adCarResponse = new AdCarResponse(ad);
                adCarResponses.add(adCarResponse);
            }

        }
        return  adCarResponses;
    }

    public List<AdCarResponse> getAllAdsForReport(long id) {
        List<AdCarResponse> adCarResponses = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        List<AdCar> adCars = new ArrayList<>();
       /* for (AdCar adCar: adCars) {
            if(adCar.getAgentAd().getId() == id) {
                for(Order order : orders) {
                    if(order.getAdCar().equals(adCar) && order.isUsingTimeUp() == true && order.isDeleted() == false) {
                        AdCarResponse adCarResponse = new AdCarResponse(adCar);
                        adCarResponses.add(adCarResponse);
                    }
                }

            }

        } */

        for(Order order : orders) {
            if(order.isUsingTimeUp() == true && order.isDeleted() == false) {
                System.out.println("usao u order");
                AdCar adCar = adCarRepository.findOneById(order.getAdCar_id().getId());
                AdCarResponse adCarResponse = new AdCarResponse(adCar);
                adCarResponses.add(adCarResponse);
            }
        }


        return  adCarResponses;
    }

    public AdCarResponse createAdAgent(AdCarRequest request,long id) {


        System.out.println(request);


        List<AdCar> adCarList = adCarRepository.findAll();

       /* for (AdCar ad: adCarList) {
            if(ad.getUserAd().getId().equals(request.getUserAd()) && ad.getUserAd() != null ) {

            }
        } */



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


        adCarRepository.save(adCar);
        AdCarResponse carResponse  = new AdCarResponse(adCar);
        return  carResponse;



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
        adCar.setCity(request.getCity());
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

   /* public AdCarResponse getAdWithMostComments() {
        AdCarResponse adCarResponse = new AdCarResponse();
        List<AdCar> adCars = new ArrayList<>();
        int most = 0;

        for (AdCar ad: adCars) {
            int current = 0;
            current = ad.getComments().size();
            if(current > most) {
                 adCarResponse = new AdCarResponse(ad);
            }

        }
        return  adCarResponse;
    } */
}
