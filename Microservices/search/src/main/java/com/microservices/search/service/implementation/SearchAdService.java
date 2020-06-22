package com.microservices.search.service.implementation;

import com.microservices.search.dto.SearchAdDTO;
import com.microservices.search.model.*;
import com.microservices.search.repository.*;
import com.microservices.search.service.ISearchAdService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchAdService implements ISearchAdService {

    @Autowired
    private SearchAdRepository searchAdRepository;

    @Autowired
    private ICarBrandRepository carBrandRepository;

    @Autowired
    private ICarModelRepository carModelRepository;

    @Autowired
    private ICarClassRepository carClassRepository;

    @Autowired
    private IFuelTypeRepository fuelTypeRepository;

    @Autowired
    private IGearShiftTypeRepository gearShiftTypeRepository;

    @Override
    public List<SearchAdDTO> getAllSearchAds() {
//        List<SearchAdDTO> searchAdResponses = null;
//        List<SearchAd> ads = searchAdRepository.findAll();
//        for(SearchAd searchAd : ads) {
//            SearchAdDTO searchAdResponse = new SearchAdDTO(searchAd);
//            searchAdResponses.add(searchAdResponse);
//        }
//        return searchAdResponses;
        List<SearchAd> searchAdList = searchAdRepository.findAll();
        return searchAdList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private SearchAdDTO mapToResponse(SearchAd searchAd) {
        SearchAdDTO response = new SearchAdDTO();
        response.setId(searchAd.getId());
        response.setCarBrand(searchAd.getCarBrand());
        response.setCarModel(searchAd.getCarModel());
        response.setFuelType(searchAd.getFuelType());
        response.setGearShiftType(searchAd.getGearShiftType());
        response.setCarClass(searchAd.getCarClass());
        response.setCity(searchAd.getCity());
        response.setGrade(searchAd.getGrade());
        response.setKmRestriction(searchAd.getKmRestriction());
        response.setKmTraveled(searchAd.getKmTraveled());
        response.setCdw(searchAd.getCdw());
        response.setKidsSeats(searchAd.getKidsSeats());
        response.setAvailableFrom(searchAd.getAvailableFrom());
        response.setAvailableTo(searchAd.getAvailableTo());
        response.setPrice(searchAd.getPrice());
        return response;
    }


    public List<SearchAd> findAll() {
            return searchAdRepository.findAll();
    }

    public SearchAdDTO addAd(SearchAdDTO searchAdDTO) throws ParseException {

        SearchAd searchAd = new SearchAd();

//        CarBrand cb = new CarBrand((long) 1, "Merzedes", "labela", false);
//        carBrandRepository.save(cb);
//        CarBrand cba = new CarBrand((long) 2, "Merzedes", "labela", false);
//        carBrandRepository.save(cba);
//        CarModel cm = new CarModel((long) 2, "CLio", false);
//        carModelRepository.save(cm);
//        CarClass cc = new CarClass((long) 3, "Karavan", false);
//        carClassRepository.save(cc);
//        FuelType tf = new FuelType((long) 4, "Dizel", false);
//        fuelTypeRepository.save(tf);
//        GearShiftType tg = new GearShiftType((long) 5, "Manual", false);
//        gearShiftTypeRepository.save(tg);
//
//
//
//        //TODO ovo vrati posle
//        searchAd.setId((long)2);
//        searchAd.setAvailableFrom(searchAdDTO.getAvailableFrom());
//        searchAd.setAvailableTo(searchAdDTO.getAvailableTo());
//        searchAd.setCdw(searchAdDTO.getCdw());
//        searchAd.setCity(searchAdDTO.getCity());
//        searchAd.setGrade(searchAdDTO.getGrade());
//        searchAd.setKidsSeats(searchAdDTO.getKidsSeats());
//        searchAd.setKmRestriction(searchAdDTO.getKmRestriction());
//        searchAd.setKmTraveled(searchAdDTO.getKmTraveled());
//        searchAd.setCarBrand(carBrandRepository.findById(searchAdDTO.getCarBrand()).orElse(null));
//        searchAd.setCarClass(carClassRepository.findById(searchAdDTO.getCarClass()).orElse(null));
//        searchAd.setCarModel(carModelRepository.findById(searchAdDTO.getCarModel()).orElse(null));
//        searchAd.setFuelType(fuelTypeRepository.findById(searchAdDTO.getFuelType()).orElse(null));
//        searchAd.setGearShiftType(gearShiftTypeRepository.findById(searchAdDTO.getGearShiftType()).orElse(null));
//        searchAd.setPrice(searchAdDTO.getPrice());
//        searchAdRepository.save(searchAd);


        CarBrand cb = carBrandRepository.findOneById(1);
        CarModel cm = carModelRepository.findOneById((long)2);
        CarClass cc = carClassRepository.findOneById(3);
        FuelType ft = fuelTypeRepository.findOneById((long)4);
        GearShiftType gst = gearShiftTypeRepository.findOneById((long)5);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dat = new String("2020-06-18");
        Date od = sdf.parse(dat);
        String dooo = new String("2020-06-29");
        Date doo = sdf.parse(dooo);


        searchAd.setId((long)3);
        searchAd.setAvailableFrom(od);
        searchAd.setAvailableTo(doo);
        searchAd.setCdw(true);
        searchAd.setCity("Novi Sad");
        searchAd.setGrade(4);
        searchAd.setKidsSeats(2);
        searchAd.setKmRestriction(200);
        searchAd.setKmTraveled(5000);
        searchAd.setCarBrand(cb);
        searchAd.setCarClass(cc);
        searchAd.setCarModel(cm);
        searchAd.setFuelType(ft);
        searchAd.setGearShiftType(gst);
        searchAd.setPrice(200);
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

//        List<SearchAd> ads = findAll();

//        List<SearchAd> ads = new ArrayList<SearchAd>();


//        CarBrand mercedez = new CarBrand((long)4);
//        CarBrand audi = new CarBrand((long)5);
//        carBrandRepository.save(mercedez);
//        carBrandRepository.save(audi);
//
//        CarModel astra = new CarModel((long)6);
//        CarModel clio = new CarModel((long)7);
//        carModelRepository.save(astra);
//        carModelRepository.save(clio);
//
//
//        TypeOfFuel diesel = new TypeOfFuel((long)8);
//        TypeOfFuel gas = new TypeOfFuel((long)9);
//        fuelTypeRepository.save(diesel);
//        fuelTypeRepository.save(gas);
//
//        TypeOfGearshift manual = new TypeOfGearshift((long)10);
//        TypeOfGearshift automatic = new TypeOfGearshift((long)11);
//        gearBoxTypeRepository.save(manual);
//        gearBoxTypeRepository.save(automatic);
//
//        CarClass caravan = new CarClass((long)12);
//        CarClass cupe = new CarClass((long)13);
//        carClassRepository.save(caravan);
//        carClassRepository.save(cupe);

        //SearchAd ad1 = new SearchAd((long) 2,mercedez,astra,diesel,manual,caravan,5,200,1000,true,2,"12:40 2-4-2012", "12:50 7-4-2012", "Novi Sad", 200);
        //SearchAd ad2 = new SearchAd((long) 3, audi, clio, gas, automatic, cupe, 4, 300, 2000, false, 4, "11:00 5-4-2012", "11:30 6-4-2012", "Novi Sad", 150);

//        ads.add(ad1);
//        ads.add(ad2);

//        searchAdRepository.save(ad1);
//        searchAdRepository.save(ad2);

//        SearchAdDTO dto1 = new SearchAdDTO(2,4,6,8,10,12,5,200,1000,true,2,"12:40 2-4-2012","12:50 7-4-2012","Novi Sad",200);
//        SearchAdDTO dto2 = new SearchAdDTO(3,4,6,8,10,12,5,200,1000,true,2,"12:40 2-4-2012","12:50 7-4-2012","Beograd",200);

        //        SearchAdDTO dto2 = new SearchAdDTO((long)3,(long)5,(long)7,(long)9,(long)11,(long)13,(long)300,2000,false,4,"11:00 5-4-2012","11:30 6-4-2012","Novi Sad", 150);

        //this.addAd(dto1);
        //this.addAd(dto2);

        List<SearchAd> ads = findAll();

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd-MM-yyyy");
        //Date dateFormatTakeOver = sdf.parse(searchAd.getAvailableFrom()); //ili promeni na Date u modelu ali onda sta sa onim hh:mm...
        //Date dateFormatReturn = sdf.parse(searchAd.getAvailableTo());

        //TODO ima ovo 48h od trenutka pretrage mora da bude preuzimanje al to se validira na frontu kontam
//        long milisecondsTakeOver = dateFormatTakeOver.getTime();
//        long milisecondsNow = now.getTime();
//        if(milisecondsNow - milisecondsTakeOver < 172800000) {
//            return null; //TODO sta ovde staviti da nije null
//        }

        List<SearchAd> searchAdsReturn = new ArrayList<>();

        for(SearchAd ad : ads) {
            //Date adDateTakeOver = sdf.parse(ad.getAvailableFrom());
            //Date adDateReturn = sdf.parse(ad.getAvailableTo());
            if(searchAd.getAvailableFrom().compareTo(ad.getAvailableFrom()) >= 0) {
                if(searchAd.getAvailableTo().compareTo(ad.getAvailableTo()) <= 0) {
                    if(searchAd.getCity().equals(ad.getCity())) {
                        if(!searchAd.getCarBrand().getName().equals("Null")) {
                            if (!(ad.getCarBrand().getId().equals(searchAd.getCarBrand().getId()))) {
                                continue;
                            }
                        }
                        if(!searchAd.getCarModel().getModel().equals("Null")) {
                            if (!(ad.getCarModel().getId().equals(searchAd.getCarModel().getId()))) {
                                continue;
                            }
                        }
                        if(!searchAd.getFuelType().getType().equals("Null")) {
                            if (!(ad.getFuelType().getId().equals(searchAd.getFuelType().getId()))) {
                                continue;
                            }
                        }
                        if(!searchAd.getGearShiftType().getType().equals("Null")) {
                            if (!(ad.getGearShiftType().getId().equals(searchAd.getGearShiftType().getId()))) {
                                continue;
                            }
                        }
                        if(!searchAd.getCarClass().getCar_class().equals("Null")) {
                            if (!(ad.getCarClass().getId().equals(searchAd.getCarClass().getId()))) {
                                continue;
                            }
                        }
                        if(searchAd.getPrice() != null) {
                            if(searchAd.getPrice() < ad.getPrice()) {
                                continue;
                            }
                        }
                        //TODO cenu uradi, treba od - do cena al ovo je privremeno sad snalazenje, mada ovde cenovnik igra ulogu ne znam sta sa time
                        if(searchAd.getGrade() != null) {
                            if(searchAd.getGrade() > ad.getGrade()) {
                                continue;
                            }
                        }
                        if(searchAd.getKmTraveled() != null) {
                            if(searchAd.getKmTraveled() < ad.getKmTraveled()) {
                                continue;
                            }
                        }
                        //TODO ovo je malo zbunjujuce, on unosi kilometrazu koju planira da predje i sta sa time, ne kaze jel mu smeta restrikcija ili ispisujem koliko treba da plati dodatno ili sta
                        if(searchAd.getKmRestriction() != null) {
                            if(searchAd.getKmRestriction() < ad.getKmRestriction()) {
                                continue;
                            }
                        }
                        if(searchAd.getCdw() != null) {
                            if(searchAd.getCdw() != ad.getCdw()) {
                                continue;
                            }
                        }
                        if(searchAd.getKidsSeats() != null) {
                            if(searchAd.getKidsSeats() > ad.getKidsSeats()) {
                                continue;
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
