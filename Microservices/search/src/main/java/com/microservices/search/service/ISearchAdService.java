package com.microservices.search.service;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.SearchAd;

import java.util.List;
import java.util.Set;

public interface ISearchAdService {

    List<SearchAdDTO> getAllSearchAds();
}
