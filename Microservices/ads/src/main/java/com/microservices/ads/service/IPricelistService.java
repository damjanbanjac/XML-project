package com.microservices.ads.service;

import com.microservices.ads.dto.request.AdCarRequest;
import com.microservices.ads.dto.request.PricelistRequest;
import com.microservices.ads.dto.response.AdCarResponse;
import com.microservices.ads.dto.response.PricelistResponse;
import com.microservices.ads.model.Pricelist;

import java.util.List;

public interface IPricelistService {

    PricelistResponse getPricelist(long id);

    List<PricelistResponse> getAllPricelist();

    PricelistResponse createPricelistUser(PricelistRequest request, long id);

    PricelistResponse createPricelistAgent(PricelistRequest request, long id);

    PricelistResponse updatePricelist(PricelistRequest request, long id);

    void deletePricelist(long id);



}
