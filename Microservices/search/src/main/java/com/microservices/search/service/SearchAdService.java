package com.microservices.search.service;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.SearchAd;
import com.microservices.search.repository.SearchAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    public List<SearchAd> searchAds(SearchAdDTO searchAd) throws ParseException {

        List<SearchAd> ads = findAll();

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd-MM-yyyy");
        Date dateFormatTakeOver = sdf.parse(searchAd.getAvailableFrom()); //ili promeni na Date u modelu ali onda sta sa onim hh:mm...
        Date dateFormatReturn = sdf.parse(searchAd.getAvailableTo());

        //TODO ima ovo 48h od trenutka pretrage mora da bude preuzimanje al to se validira na frontu kontam


        List<SearchAd> searchAdsReturn = new ArrayList<>();

        for(SearchAd ad : ads) {
            Date adDateTakeOver = sdf.parse(ad.getAvailableFrom());
            Date adDateReturn = sdf.parse(ad.getAvailableTo());
            if(dateFormatTakeOver.compareTo(adDateTakeOver) >= 0) {
                if(dateFormatReturn.compareTo(adDateReturn) <= 0) {
                    if(searchAd.getCity().equals(ad.getCity())) {
                        if(searchAd.getCarBrand() != null) {
                            if (!(ad.getCarBrand().getId().equals(searchAd.getCarBrand().getId()))) {
                                break;
                            }
                        }
                        if(searchAd.getCarModel() != null) {
                            if (!(ad.getCarModel().getId().equals(searchAd.getCarModel().getId()))) {
                                break;
                            }
                        }
                        if(searchAd.getFuelType() != null) {
                            if (!(ad.getFuelType().getId().equals(searchAd.getFuelType().getId()))) {
                                break;
                            }
                        }
                        if(searchAd.getGearBoxType() != null) {
                            if (!(ad.getGearBoxType().getId().equals(searchAd.getGearBoxType().getId()))) {
                                break;
                            }
                        }
                        if(searchAd.getCarClass() != null) {
                            if (!(ad.getCarClass().getId().equals(searchAd.getCarClass().getId()))) {
                                break;
                            }
                        }
                        //TODO cenu uradi, treba od - do cena al ovo je privremeno sad snalazenje, mada ovde cenovnik igra ulogu ne znam sta sa time
                        if(searchAd.getPrice() != null) {
                            if(searchAd.getPrice() < ad.getPrice()) {
                                break;
                            }
                        }
                        if(searchAd.getKmTraveled() != null) {
                            if(searchAd.getKmTraveled() < ad.getKmTraveled()) {
                                break;
                            }
                        }
                        //TODO ovo je malo zbunjujuce, on unosi kilometrazu koju planira da predje i sta sa time, ne kaze jel mu smeta restrikcija ili ispisujem koliko treba da plati dodatno ili sta
                        if(searchAd.getKmRestriction() != null) {
                            if(searchAd.getKmRestriction() > ad.getKmRestriction()) {
                                break;
                            }
                        }
                        if(searchAd.getCdw() != null) {
                            if(searchAd.getCdw() != ad.getCdw()) {
                                break;
                            }
                        }
                        if(searchAd.getKidsSeats() != null) {
                            if(searchAd.getKidsSeats() > ad.getKidsSeats()) {
                                break;
                            }
                        }

                        searchAdsReturn.add(ad);
                    }
                }
            }
        }
        return searchAdsReturn;
    }

}
