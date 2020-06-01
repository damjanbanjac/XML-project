package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdsCarService implements IAdsCarService {

    @Override
    public AdCarResponse getAd(long id) {
        return null;
    }

    @Override
    public Set<AdCarResponse> getAllAds() {
        return null;
    }

    public AdCarResponse createAd(AdCarRequest request) {
         AdCarResponse carResponse  = new AdCarResponse();
         return  carResponse;
    }

    @Override
    public AdCarResponse updateAd(AdCarRequest request, long id) {
        return null;
    }

    @Override
    public void deleteAdCar(long id) {

    }

    @Override
    public Integer getAverageGrade(long id) {
        return null;
    }

}
