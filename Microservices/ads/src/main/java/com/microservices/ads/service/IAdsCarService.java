package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;

import java.util.Set;

public interface IAdsCarService {

    AdCarResponse getAd(long id);

    Set<AdCarResponse> getAllAds();

    AdCarResponse createAd(AdCarRequest request);

    AdCarResponse updateAd(AdCarRequest request, long id);

    void deleteAdCar(long id);

    Integer getAverageGrade(long id);



}
