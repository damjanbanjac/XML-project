package com.microservices.search.controller;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.SearchAd;
import com.microservices.search.service.implementation.SearchAdService;
import com.netflix.discovery.converters.Auto;
import com.netflix.ribbon.proxy.annotation.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchAdService searchAdService;

    List<SearchAd> searchAdsResult = null;

    private final Logger logger = LoggerFactory.getLogger(SearchController.class);


    @PostMapping(value="/ad")
    public ResponseEntity<Collection<SearchAdDTO>> searchAds(@RequestBody SearchAdDTO searchAd) throws ParseException {
        Map<Long,SearchAdDTO> adsDTO = new HashMap();

        if(searchAd == null) {
            searchFailedLog();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        searchAdsResult = searchAdService.searchAds(searchAd);

        for(SearchAd searchAdReturn : searchAdsResult) {
            adsDTO.put(searchAdReturn.getId(), new SearchAdDTO(searchAdReturn));
        }
        searchSuccessfulLog();
        return new ResponseEntity<>(adsDTO.values(), HttpStatus.OK);
    }

    @GetMapping(value="/{sortBy}/{sortType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<SearchAdDTO>> sortAds(@PathVariable String sortBy, @PathVariable String sortType) {
        List<SearchAd> sortedSearchAds = null;
//        String sortByy = new String("kmTraveled");
//        String sortTypee = new String(("asc"));
        if(searchAdsResult != null) {
            sortedSearchAds = searchAdService.sortAds(searchAdsResult,sortBy,sortType);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Map<Long,SearchAdDTO> adsDTO = new HashMap();
//        for(int i = 0; i < sortedSearchAds.size(); i++) {
//            adsDTO.put(i, new SearchAdDTO(sortedSearchAds.get(i)));
//        }
        for(SearchAd ad : sortedSearchAds) {
            adsDTO.put(ad.getId(), new SearchAdDTO(ad));
        }

        return new ResponseEntity<>(adsDTO.values(), HttpStatus.OK);
    }

    @PostMapping(value = "/addad")
    public ResponseEntity<SearchAdDTO> addAd(@RequestBody SearchAdDTO searchAdDTO) throws Exception {

        SearchAdDTO searchaddto = new SearchAdDTO();
        searchaddto = searchAdService.addAd(searchAdDTO);

        return new ResponseEntity<>(searchaddto, HttpStatus.OK);
    }

    @GetMapping(value = "/ads", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchAdDTO>> getAllAds() throws Exception {
        List<SearchAdDTO> response = searchAdService.getAllSearchAds();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public void searchSuccessfulLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS User successfully searched ads.");
//        }
    }

    public void searchFailedLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("FAILURE User failed to search ads.");
//        }
    }

}
