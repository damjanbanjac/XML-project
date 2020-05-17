package com.microservices.payment.service;

import com.microservices.payment.dto.PricelistDTO;

import java.util.Set;

public interface PricelistService {

    PricelistDTO getPricelist(long id);

    Set<PricelistDTO> getAllPricelists();

    PricelistDTO createPricelistUser(PricelistDTO request);

    PricelistDTO createPricelistAgent(PricelistDTO request);


}
