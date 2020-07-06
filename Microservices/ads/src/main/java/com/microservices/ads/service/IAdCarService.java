package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface IAdCarService {

    AdCarResponse getAd(long id);

    List<AdCarResponse> getAllAds();

    //   AdCarResponse createAd(AdCarRequest request);

    AdCarResponse updateAd(AdCarRequest request, long id);

    void deleteAdCar(long id);

    Integer getAverageGrade(long id);



}
