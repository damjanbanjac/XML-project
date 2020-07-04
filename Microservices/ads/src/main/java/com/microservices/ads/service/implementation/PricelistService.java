package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.request.PricelistRequest;
import com.microservices.ads.dto.response.PricelistResponse;
import com.microservices.ads.model.AdCar;
import com.microservices.ads.model.Pricelist;
import com.microservices.ads.repository.AdCarRepository;
import com.microservices.ads.repository.PricelistRepository;
import com.microservices.ads.service.IAdCarService;
import com.microservices.ads.service.IPricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PricelistService implements IPricelistService {

    @Autowired
    PricelistRepository pricelistRepository;

    @Autowired
    AdCarRepository adCarRepository;

    @Override
    public PricelistResponse getPricelist(long id) {
        AdCar adCar = adCarRepository.findOneById(id);
        long idPricelist = adCar.getPricelist();

        Pricelist pricelist = pricelistRepository.findOneById(idPricelist);
        PricelistResponse pricelistResponse = new PricelistResponse(pricelist);
        return  pricelistResponse;
    }

    @Override
    public List<PricelistResponse> getAllPricelist() {
        List<PricelistResponse> pricelistResponses =new ArrayList<>();
        List<Pricelist> pricelists = pricelistRepository.findAll();
        for(Pricelist p : pricelists) {
            if(p.isDeleted() == false) {
                PricelistResponse pricelistResponse = new PricelistResponse(p);
                pricelistResponses.add(pricelistResponse);

            }
        }

        return pricelistResponses;
    }

    @Override
    public PricelistResponse createPricelistUser(PricelistRequest request, long id) {
        Pricelist pricelist = new Pricelist();
        pricelist.setName(request.getName());
        pricelist.setUser(id);
        pricelist.setPriceForCDW(request.getPriceForCDW());
        pricelist.setPriceForKmRestriction(request.getPriceForKmRestriction());
        pricelist.setPriceForWorkDay(request.getPriceForWorkDay());
        pricelist.setPriceForWeekend(request.getPriceForWeekend());
        pricelist.setDeleted(false);
        pricelistRepository.save(pricelist);
        return null;
    }

    @Override
    public PricelistResponse createPricelistAgent(PricelistRequest request, long id) {
        Pricelist pricelist = new Pricelist();
        pricelist.setName(request.getName());
        pricelist.setAgent(id);
        pricelist.setPriceForCDW(request.getPriceForCDW());
        pricelist.setPriceForKmRestriction(request.getPriceForKmRestriction());
        pricelist.setPriceForWorkDay(request.getPriceForWorkDay());
        pricelist.setPriceForWeekend(request.getPriceForWeekend());
        pricelist.setDeleted(false);
        pricelistRepository.save(pricelist);
        return null;
    }

    @Override
    public PricelistResponse updatePricelist(PricelistRequest request, long id) {
        Pricelist pricelist = pricelistRepository.findOneById(id);
        pricelist.setName(request.getName());
        // pricelist.setAgent(id);
        pricelist.setPriceForCDW(request.getPriceForCDW());
        pricelist.setPriceForKmRestriction(request.getPriceForKmRestriction());
        pricelist.setPriceForWorkDay(request.getPriceForWorkDay());
        pricelist.setPriceForWeekend(request.getPriceForWeekend());

        pricelistRepository.save(pricelist);
        return null;
    }

    @Override
    public void deletePricelist(long id) {
        Pricelist pricelist = pricelistRepository.findOneById(id);
        pricelist.setDeleted(true);
    }

    public List<PricelistResponse> getAllPricelistUser(long id) {
        List<PricelistResponse> pricelistResponses =new ArrayList<>();
        List<Pricelist> pricelists = pricelistRepository.findAll();
        for(Pricelist p : pricelists) {
            if(p.isDeleted() == false && p.getUser() == id) {
                PricelistResponse pricelistResponse = new PricelistResponse(p);
                pricelistResponses.add(pricelistResponse);

            }
        }

        return pricelistResponses;
    }

    public List<PricelistResponse> getAllPricelistAgent(long id) {
        List<PricelistResponse> pricelistResponses =new ArrayList<>();
        List<Pricelist> pricelists = pricelistRepository.findAll();
        for(Pricelist p : pricelists) {
            if(p.isDeleted() == false && p.getAgent() == id) {
                PricelistResponse pricelistResponse = new PricelistResponse(p);
                pricelistResponses.add(pricelistResponse);

            }
        }

        return pricelistResponses;
    }
}
