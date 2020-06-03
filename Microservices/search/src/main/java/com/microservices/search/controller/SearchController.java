package com.microservices.search.controller;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.SearchAd;
import com.microservices.search.service.SearchAdService;
import com.netflix.discovery.converters.Auto;
import com.netflix.ribbon.proxy.annotation.Http;
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

    @PostMapping(value = "/{city}/{takoOverDate}/{returnDate}")
    public ResponseEntity<Collection<SearchAdDTO>> searchAds(@PathVariable String city, @PathVariable String takeOverDate, @PathVariable String returnDate) throws ParseException {

        List<SearchAd> ads = searchAdService.findAll();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd-MM-yyyy");
        Date dateFormatTakeOver = sdf.parse(takeOverDate);
        Date dateFormatReturn = sdf.parse(returnDate);

        Map<Long,SearchAdDTO> adsDTO = new HashMap();

        for(SearchAd searchAd : ads) {
            if(dateFormatTakeOver.compareTo(searchAd.getAvailableFrom()) >= 0) {
                if(dateFormatReturn.compareTo(searchAd.getAvailableTo()) <= 0) {
                    if(city.equals(searchAd.getCity())) {
                        adsDTO.put(searchAd.getId(), new SearchAdDTO(searchAd));
                        searchAdsResult.add(searchAd);
                    }
                }
            }
        }



        return new ResponseEntity<>(adsDTO.values(), HttpStatus.OK);
    }


    @PostMapping(value="/{sortBy}/{sortType}")
    public ResponseEntity<Collection<SearchAdDTO>> sortAds(@PathVariable String sortBy, @PathVariable String sortType) {
        List<SearchAd> sortedSearchAds = null;
        if(searchAdsResult != null) {
            sortedSearchAds = searchAdService.sortAds(searchAdsResult,sortBy,sortType);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Map<Integer,SearchAdDTO> adsDTO = new HashMap();
        for(int i = 0; i < sortedSearchAds.size(); i++) {
            adsDTO.put(i, new SearchAdDTO(sortedSearchAds.get(i)));
        }

        return new ResponseEntity<>(adsDTO.values(), HttpStatus.OK);
    }

    @PostMapping(value = "/ad", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchAdDTO> addAd(@RequestBody SearchAdDTO searchAdDTO) throws Exception {

        SearchAdDTO searchaddto = new SearchAdDTO();
        searchaddto = searchAdService.addAd(searchAdDTO);

        return new ResponseEntity<>(searchaddto, HttpStatus.OK);
    }

}
