package com.microservices.search.service;

import com.microservices.search.dto.SearchAdDTO;

import java.util.Set;

public interface ISearchAdService {

    Set<SearchAdDTO> getAllSearchAds();
}
