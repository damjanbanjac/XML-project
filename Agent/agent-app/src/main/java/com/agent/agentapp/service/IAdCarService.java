package com.agent.agentapp.service;


import com.agent.agentapp.dto.request.AdCarRequest;
import com.agent.agentapp.dto.response.AdCarResponse;

import java.util.List;

public interface IAdCarService {

    AdCarResponse getAd(long id);

    List<AdCarResponse> getAllAds();

    AdCarResponse createAd(AdCarRequest request);

    AdCarResponse updateAd(AdCarRequest request, long id);

    void deleteAdCar(long id);

    Integer getAverageGrade(long id);



}
