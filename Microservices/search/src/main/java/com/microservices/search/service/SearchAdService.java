package com.microservices.search.service;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.SearchAd;
import com.microservices.search.repository.SearchAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SearchAdService implements ISearchAdService {

    @Autowired
    private SearchAdRepository searchAdRepository;

    @Override
    public Set<SearchAd> getAllSearchAds() {
        return null;
    }
    public List<SearchAd> findAll() {
            return searchAdRepository.findAll();
    }

    public SearchAdDTO addAd(SearchAdDTO searchAdDTO) {

        SearchAd searchAd = new SearchAd();

        //searchAd.setId(searchAdDTO.getId());
        searchAd.setAvailableFrom(searchAdDTO.getAvailableFrom());
        searchAd.setAvailableTo(searchAdDTO.getAvailableTo());
        searchAd.setCdw(searchAdDTO.getCdw());
        searchAd.setCity(searchAdDTO.getCity());
        searchAd.setGrade(searchAdDTO.getGrade());
        searchAd.setKidsSeats(searchAdDTO.getKidsSeats());
        searchAd.setKmRestriction(searchAdDTO.getKmRestriction());
        searchAd.setKmTraveled(searchAdDTO.getKmTraveled());
        searchAd.setCarBrand(searchAdDTO.getCarBrand());
        searchAd.setCarClass(searchAdDTO.getCarClass());
        searchAd.setCarModel(searchAdDTO.getCarModel());
        searchAd.setFuelType(searchAdDTO.getFuelType());
        searchAd.setGearBoxType(searchAdDTO.getGearBoxType());
        searchAd.setPrice(searchAdDTO.getPrice());
        searchAdRepository.save(searchAd);

        SearchAdDTO searchaddto =new SearchAdDTO(searchAd);
        return searchaddto;
    }

    public List<SearchAd> sortAds(List<SearchAd> searchAds, String sortBy, String sortType) {

        int i,j;

        if(sortBy.equals("price") && sortType.equals("asc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getPrice() > searchAds.get(i+1).getPrice()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        } else if(sortBy.equals("price") && sortType.equals("desc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getPrice() < searchAds.get(i+1).getPrice()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        } else if(sortBy.equals("grade") && sortType.equals("asc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getGrade() > searchAds.get(i+1).getGrade()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        } else if(sortBy.equals("grade") && sortType.equals("desc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getGrade() < searchAds.get(i+1).getGrade()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        } else if(sortBy.equals("kmTraveled") && sortType.equals("asc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getKmTraveled() > searchAds.get(i+1).getKmTraveled()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        } else if(sortBy.equals("kmTraveled") && sortType.equals("desc")){
            for(i = 0; i < searchAds.size() - 1; i++) {
                for(j = 0; j < searchAds.size() - i - 1; j++) {
                    if(searchAds.get(i).getKmTraveled() < searchAds.get(i+1).getKmTraveled()) {
                        SearchAd temp = searchAds.get(i);
                        searchAds.set(i, searchAds.get(i + 1));
                        searchAds.set(i + 1, temp);
                    }
                }
            }
        }

        return searchAds;
    }


}
